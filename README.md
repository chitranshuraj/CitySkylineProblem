# Project Logistics and Implementation
# Problem Statement
A city’s skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed
from a distance. Given the locations and heights of all the buildings, return the skyline formed by these
buildings collectively.
You are given a list of the building x-coordinates and their heights:
(l1, h1, r1), (l2, h2, r2), ..., (ln, hn, rn)
Here, we will assume all values are between 1 and 100. The list will be sorted in increasing order of
left-most x-coordinate. Format of the output would be :
(x1, y1), (x2, y2), (x3, y3), ...
This means that at x1 we draw a building at height y1 until x2 at which point we draw a line up or down
to high y2 and then continue horizontally until x3 and so on.
# Implementation
The given Skyline problem can be solved in O(n * log(n))- time by developing an algorithm which works as an implementation of divide and conquer and merge sort.
In my implementation of the algorithm, I divide the given skyline into two parts recursively and save the obtained skylines in two lists left skyline and right skyline, respectively. The two lists left skyline and right skyline are then compared based on height element and the skyline with greater height is saved along with its x coordinate. The x coordinates and their respective heights are then merged into a merged list which is passed through a redundancy function to clear redundant points. The new list obtained is returned as the output.
I have also used simulated data to check the efficiency of the algorithm on 10 points,
100 points, 1000 points, 10000 points and 100000 points respectively. 

The output is as follows: 

![image](https://user-images.githubusercontent.com/56484260/116824999-1190ad80-ab5b-11eb-8254-b143d5349f4a.png)
![image](https://user-images.githubusercontent.com/56484260/116824966-ddb58800-ab5a-11eb-9848-c146cc7ac784.png)

The graph represents an O(n * log(n)) graph. The x-coordinate axis is arranged according to the number of buildings and the y-coordinate axis represents the run-time for each of the input sets. As the range increases, the graph becomes linear, however, the run time is not fluctuating as the number of inputs reach 100,000 buildings. 
This shows the efficiency of O(n * log(n)) run-time. 


