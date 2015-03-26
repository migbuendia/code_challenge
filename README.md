# code_challenge

Implementation of Jama's coding challenge

This is my submission of the code challenge for the Supermarket checkout()


A little about the implementation

The Supermarket class contains the supermarket products, the sales offers, and it takes care of the register checkout for the products sale.

The implementation uses a factory pattern to create different offers which contain their own discount rule.

As specified in the description of the challenge the products are sent in a String were each character represents a product, because a product can be sent but might not be in existence validation was added for it.

The supermarket has access to the products so it can change the price, add, and remove products.

jUnit tests are in place to test for different scenarios; this includes running it through the given list of products, through two different offers, change the price of a product between purchases, added a non-existing product for example.


I hope that this will suffice the requirements for the challenge.

Thank you,
Miguel

