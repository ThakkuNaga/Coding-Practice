package com.math;

class RobotBoundedBox {
    /*
    Input: instructions = "GGLLGG"
    Output: true
    Explanation: The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
    When repeating these instructions, the robot remains in the circle of radius 2 centered at the origin.
    */
    public static void main(String[] args) {
        String ins = "GGLLGG";
        System.out.println(isRobotBounded(ins));
    }

    public static boolean isRobotBounded(String ins) {
        int x = 0, y = 0, i = 0, d[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        for (int j = 0; j < ins.length(); ++j)
            if (ins.charAt(j) == 'R')
                i = (i + 1) % 4;
            else if (ins.charAt(j) == 'L')
                i = (i + 3) % 4;
            else {
                x += d[i][0];
                y += d[i][1];
            }
        return x == 0 && y == 0 || i > 0;
    }

    /*
    Intuition
    Let chopper help explain.

    Starting at the origin and face north (0,1),
    after one sequence of instructions,

    if chopper return to the origin, he is obvious in an circle.
    if chopper finishes with face not towards north,
    it will get back to the initial status in another one or three sequences.

    Explanation
    (x,y) is the location of chopper.
    d[i] is the direction he is facing.
    i = (i + 1) % 4 will turn right
    i = (i + 3) % 4 will turn left
    Check the final status after instructions.


    Complexity
    Time O(N)
    Space O(1)
*/

public static boolean isRobotBounded2(String instructions) {
    if (instructions.length() == 0)
        return false;
    int x = 0;
    int y = 0;  // initial points of the robot
    String directions = "North"; // initial direction of robot
    /*
                North
        West                East
                South
                
    */
    for (char ch: instructions.toCharArray()) {
        if (ch == 'G') {
            if (directions.equals("North"))
                y += 1;
            else if (directions.equals("South"))
                y -= 1;
            else if(directions.equals("East"))
                x += 1;
            else
                x -= 1;
        }
        else if (ch == 'L') {
            if (directions.equals("North"))
                directions = "West";
            else if (directions.equals("West"))
                directions = "South";
            else if (directions.equals("South"))
                directions = "East";
            else directions = "North";
        }
        else if (ch == 'R') {
            if (directions.equals("North"))
                directions = "East";
            else if (directions.equals("East"))
                directions = "South";
            else if (directions.equals("South"))
                directions = "West";
            else directions = "North";
        }
    }
    if (x == 0 && y == 0)
        return true;
    if (directions.equals("North"))
        return false;
    return true;
}

}