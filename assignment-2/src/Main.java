import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple manual test harness for the generated model.
 * Since we are not using JUnit here, we simulate assertions and
 * print a structured test report. Each test throws an exception
 * on failure and stops execution, otherwise we accumulate PASS lines.
 */
public class Main {

    private static final List<String> report = new ArrayList<>();

    private static void check(String name, boolean condition) {
        if (!condition) {
            throw new AssertionError("TEST FAILED: " + name);
        }
        report.add("PASS: " + name);
    }

    private static Date now() { return new Date(System.currentTimeMillis()); }

    public static void main(String[] args) {
        // ============== 1. Singleton Bank Instance ==============
        BMO bank1 = BMO.getInstance();
        BMO bank2 = BMO.getInstance();
        check("Singleton BMO instance", bank1 == bank2);

        // ============== 2. Create Various Adult Clients ==============
        Individual individual = new Individual("John", "Doe", now(), "111-111-111", "(613)111-1111", "john@example.com", "123 Main St", 1001, now(), "active", bank1, "Engineer", 120000, "ACME");
        Investor investor = new Investor("Jane", "Roe", now(), "222-222-222", "(613)222-2222", "jane@example.com", "456 Side St", 1002, now(), "active", bank1, "Analyst", 150000, "moderate", 2500000, 8);
        SmallBusiness smb = new SmallBusiness("Sam", "Biz", now(), "333-333-333", "(613)333-3333", "sam@example.com", "789 Market St", 1003, now(), "active", bank1, "Owner", 90000, "Sam's Bakery", "BN-123", 12, "Food");
        LargeBusiness corp = new LargeBusiness("Laura", "Corp", now(), "444-444-444", "(613)444-4444", "laura@example.com", "101 Corporate Dr", 1004, now(), "active", bank1, "CEO", 500000, "MegaCorp", "CN-999", 1000, "Tech", "MCORP");

        check("Active clients after adult creation", bank1.numberOfActiveClients() >= 4);

        // ============== 3. Student and Minor (with guardians) ==============
        Student student = new Student("Stu", "Dent", now(), "555-555-555", "(613)555-5555", "stu@example.com", "202 Uni Ave", 1005, now(), "active", bank1, "uOttawa", "u123456", "CS", now());
        Minor minor = new Minor("Tim", "Tiny", now(), "666-666-666", "(613)666-6666", "tim@example.com", "303 Kid Rd", 1006, now(), "active", bank1, "Elementary School", individual, investor); // two guardians
        check("Minor has 2 guardians", minor.numberOfGuardian() == 2);
        check("Guardian back-link 1", individual.getGuardedMinor().contains(minor));
        check("Guardian back-link 2", investor.getGuardedMinor().contains(minor));

        // Verify cannot add a 3rd guardian
        boolean thirdGuardianAdded = minor.addGuardian(smb);
        check("Cannot exceed max guardians", !thirdGuardianAdded && minor.numberOfGuardian() == 2);

        // ============== 4. Loyalty Program Account (1:1 optional) ==============
        LoyaltyProgramAccount loyalty = new LoyaltyProgramAccount(5001, 1000, "silver", now(), individual);
        check("Loyalty linked to individual", individual.getLoyaltyAccount() == loyalty);
        // Attempt to assign a second loyalty account to same client (should fail due to constraint logic)
        boolean blockedSecondLoyalty = false;
        try {
            LoyaltyProgramAccount secondAttempt = new LoyaltyProgramAccount(5002, 0, "bronze", now(), individual);
        } catch (RuntimeException ex) {
            blockedSecondLoyalty = true; // Expected: existing loyalty prevents new one
        }
        check("Second loyalty assignment blocked", blockedSecondLoyalty && individual.getLoyaltyAccount() == loyalty);

        // ============== 5. Accounts (inheritance + associations) ==============
        CheckingAccount chk = new CheckingAccount(900001, 1500.75, now(), "active", individual, "Daily Chequing", 200, 999);
        SavingsAccount sav = new SavingsAccount(900002, 5000.00, now(), "active", individual, "Rainy Day", 2.5, 100.00);
        InvestmentAccount invAcct = new InvestmentAccount(900003, 20000.00, now(), "active", investor, "Growth Fund", "mutual funds", 6.0);
        LoanAccount loan = new LoanAccount(900004, 10000.00, now(), "active", smb, 4.5, 15000.00, 10000.00, now(), "term");
        check("Individual account count", individual.numberOfAccounts() == 2);
        check("Investor account count", investor.numberOfAccounts() == 1);
        check("Small business loan count", smb.numberOfAccounts() == 1);

        // Duplicate account number test (should throw)
        boolean duplicateFailed = false;
        try {
            new CheckingAccount(900001, 1.0, now(), "active", student, "Dup", 0, 0);
        } catch (RuntimeException ex) { duplicateFailed = true; }
        check("Duplicate account number rejected", duplicateFailed);

        // ============== 6. Investment Portfolio Items (1..* to account) ==============
        InvestmentItem itm1 = invAcct.addInPortfolio("AAPL", "Apple", 10, 150.0, 180.0);
        InvestmentItem itm2 = invAcct.addInPortfolio("GOOG", "Alphabet", 5, 1000.0, 1200.0);
        check("Investment items count", invAcct.numberOfInPortfolio() == 2);
        check("Investment item back-link", itm1.getInvestmentAccount() == invAcct);

        // ============== 7. Loyalty Transactions & Rewards (many-to-many) ==============
        PointTransaction earn = loyalty.addTransaction(now(), 500, "earned", "Signup Bonus");
        PointTransaction redeemTxn = loyalty.addTransaction(now(), -300, "redeemed", "Gift Redemption");
        check("Transactions recorded", loyalty.numberOfTransactions() == 2);

        Reward reward1 = new Reward(7001, "Travel Voucher", "$100 flight credit", 300, "travel", true);
        Reward reward2 = new Reward(7002, "Mug", "Ceramic mug", 50, "merchandise", true);
        boolean addReward1 = loyalty.addRedeemedReward(reward1);
        boolean addReward2 = loyalty.addRedeemedReward(reward2);
        check("Rewards linked", addReward1 && addReward2 && loyalty.numberOfRedeemedRewards() == 2);
        check("Reward back-link count", reward1.numberOfLoyaltyProgramAccounts() == 1);

        // ============== 8. Removal / Mutability Constraints ==============
        boolean removedGuardian = minor.removeGuardian(investor); // should succeed (still 1 guardian remains)
        check("Guardian removal above min", removedGuardian && minor.numberOfGuardian() == 1);
        boolean cannotRemoveLastGuardian = minor.removeGuardian(individual); // should fail (would violate min 1)
        check("Cannot remove last guardian", !cannotRemoveLastGuardian && minor.numberOfGuardian() == 1);

        // Attempt to remove account directly from owner (must keep owner) -> removeAccount returns false
        boolean removeAccountDisallowed = individual.removeAccount(chk); // should be false because account still owned
        check("Cannot orphan account from owner side", !removeAccountDisallowed && individual.numberOfAccounts() == 2);

        // ============== 9. Cascading Delete (client -> accounts + loyalty) ==============
        int totalAccountsBeforeDelete = bank1.getActiveClient(bank1.indexOfActiveClient(individual)).numberOfAccounts();
        individual.delete();
        check("Individual removed from bank", !bank1.getActiveClients().contains(individual));
        check("Cascade deleted loyalty", LoyaltyProgramAccount.getWithMemberNumber(5001) == null);
        // Validate static uniqueness map removal by probing known account numbers
        check("Accounts deleted on cascade", Account.getWithAccountNumber(900001) == null && Account.getWithAccountNumber(900002) == null);

        // ============== 10. Summary Integrity Checks ==============
        check("Bank still singleton after operations", bank1 == BMO.getInstance());
        check("Remaining active clients >= 4", bank1.numberOfActiveClients() >= 4); // after deleting one of initial set

        // Print structured report
        System.out.println("==== TEST REPORT (" + report.size() + " tests) ====");
        for (String line : report) {
            System.out.println(line);
        }
        System.out.println("ALL TESTS PASSED");
    }
}
