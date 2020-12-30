import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DistanceBetweenCoords 
{
    public static void main(String args[] ) throws Exception 
    {
        Scanner sc = new Scanner(System.in);
        //take in all the Coordinate information and turn it into radians 
        double firstHalfOfFirstCoord = Math.toRadians(sc.nextDouble());
        double secondHalfOfFirstCoord=Math.toRadians(sc.nextDouble());
        double firstHalfOfSecondCoord=Math.toRadians(sc.nextDouble());
        double secondHalfOfSecondCoord = Math.toRadians(sc.nextDouble());
        int notRounded = (int)distanceBetweenCoordinates(firstHalfOfFirstCoord, secondHalfOfFirstCoord, firstHalfOfSecondCoord, secondHalfOfSecondCoord);
        int roundedDistance = rounding(notRounded);
        System.out.print(roundedDistance);
    }

    public static int rounding(int distance)
    {
        int modulo = distance%100;
        int remainder =100-modulo;
        if(modulo>=50)
        {
            distance = distance + remainder;
        }
        else
        {
            distance=distance-modulo;
        }
        return distance;

    }
    public static double distanceBetweenCoordinates(double coordinate1FirstHalf, double coordinate1SecondHalf, double Coordinate2FirstHalf, double Coordinate2SecondHalf) 
    {
        int radiusOfEarth= 6371; 
        return radiusOfEarth * Math.acos(Math.sin(coordinate1FirstHalf)*Math.sin(Coordinate2FirstHalf) + Math.cos(coordinate1FirstHalf)*Math.cos(Coordinate2FirstHalf)*Math.cos(coordinate1SecondHalf - Coordinate2SecondHalf));
    }

}
