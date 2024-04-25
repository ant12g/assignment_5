/****************************************************************
 File: Assignment5_Objective-1
 By: Antonio Gonzalez
 Date: 04/24/2024
 Description: Implementing software pattern for BankCustomer
        To understand and implement the Builder design pattern
        for BankCustomer class.

 ****************************************************************/
// BankCustomer class
public class BankCustomer {
    private String name;
    private String accountNumber;
    private String email;

    private BankCustomer(BankCustomerBuilder builder) {
        this.name = builder.name;
        this.accountNumber = builder.accountNumber;
        this.email = builder.email;
    }

    @Override
    public String toString() {
        return "BankCustomer {\n" +
                "name = " + name + '\n' +
                "accountNumber = " + accountNumber + '\n' +
                "email = " + email + '\n' +
                '}';
    }
    //Builder Class
    public static class BankCustomerBuilder {
        private String name;
        private String accountNumber;
        private String email;

        public BankCustomerBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public BankCustomerBuilder setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public BankCustomerBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public BankCustomer build() {
            return new BankCustomer(this);
        }
    }
}
//Test class
 class BankCustomerTest {
    public static void main(String[] args) {
        // Instantiate a BankCustomerBuilder
        BankCustomer.BankCustomerBuilder builder = new BankCustomer.BankCustomerBuilder();

        // Set the attributes of the BankCustomer using the builder's setter methods
        builder.setName("Antonio G");
        builder.setAccountNumber("1234567");
        builder.setEmail("ag@sfsu.edu");

        // Call the build() method to obtain the BankCustomer object
        BankCustomer customer = builder.build();

        // Print the details of the BankCustomer object using the overridden toString method
        System.out.println(customer);
    }
}


//Sample output

/*
BankCustomer {
name = Antonio G
accountNumber = 1234567
email = ag@sfsu.edu
}

 */