# restaurant
The main goal of this repo is to create an app where it's possible to apply some of the concurrency 
Java API concepts and RxJava 2 as well.

The restaurant implementation is a basic modeling of how the dishes are created based on the 
ingredients that each dish is composed of and the steps needed to cook it up e.g. Beef has to be 
sliced, seasoned and cooked.

The idea is that each preparation step has a defined unit time to be completed and depending on
how many cook and stove burners the restaurant have the steps can be done in parallel.

This is where the concurrency takes place. Let's take a look at the different possible ways of 
implementation using Java API and RxJava 2.


###Increments
* First Increment
```bash
$ git checkout 92d324dce3cb335124f620f380bc33df39ea9d7c
```

* Second Increment
```bash
$ git checkout bff4eff42f129d07ce5d67d8497307863f9aed9f
```