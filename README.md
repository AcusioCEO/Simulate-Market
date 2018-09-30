# Simulate-Market

This is a Java application that simulates Stock Market Returns based on the weekly percent return information of how the SP500 performed from 1/1/1950 to 8/24/2018 (3582 weeks). That data is in the text file “SP500-Weekly.txt”. The data used to
create the weekly percent return was retrieved from Yahoo finance’s historical data for the SP500.

There are three simulation models: Linear, Distributional, and Monte Carlo.

Note: Simulations assume a starting investment of $100.

Linear simulation.
With the starting equity, increase the equity value weekly (3582 times) by the average (0.0016) and median (0.0029) weekly return statistics from the actual SP500 distribution. There are two linear simulation runs; using the average and using the median values from the SP500 weekly returns as the constant weekly increase.

Distributional simulation.
SimulateMarket uses an instance of Sample named “equity” for the distributional simulation technique. With the starting equity, increase the equity value weekly by randomly sampling from a normal distribution with a mean (average and median) and standard deviation. Uses Java’s Random.nextGaussian(mean, stdev) method to sample values from a normal distribution.

Monte Carlo simulation.
With the starting equity, increase the equity value weekly by a random sampled from the SP500 weekly return distribution and simulate 3582 weeks of stock market return. Use Java’s Random class’s nextInt(max) method to get a random weekly return from the posted weekly return data. One could sample a random value from an ArrayList of Double values name “data” with the following code snippet

![alt text](https://raw.githubusercontent.com/username/projectname/branch/path/to/img.png)
