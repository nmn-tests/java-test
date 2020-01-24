### Java Test

A Simple Implementation of Henry's Grocery Shop

`make help` will give you all the available options

```
$ make help

 Choose a command run in java-test:

report                         Opens coverage report
run                            Runs the application
test                           Clean, Compile, Test and Generate Coverage Report
```

#### Running

Requires JDK 11. It used Maven wrapper so should download any required dependencies.

The following command uses maven to execute the main class.

```
make run
```

Once running, enter one of the products listed in the prompt then enter the quantity. 
To quit, enter checkout to calculate basket cost.

Here is a sample execution

```bash
nmn$ make run
Henry's Grocery Shop
Enter any items in the following list or "checkout" to calculate basket cost
SOUP,BREAD,APPLE,MILK
soup
Enter item quantity
3
Enter any items in the following list or "checkout" to calculate basket cost
SOUP,BREAD,APPLE,MILK
bread
Enter item quantity
2
Enter any items in the following list or "checkout" to calculate basket cost
SOUP,BREAD,APPLE,MILK
checkout
Basket Total: 3.15
```

#### Tests 

To run the tests

```
make test
```

#### Coverage

It will open the Jococo report in the system browser.

```
make report
```