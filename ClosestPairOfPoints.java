import java.util.*;

// Guidelines:

// Define a Point class to represent points in 2D space.
// Implement a method to calculate the distance between two points.
// Implement a brute force method to find the closest pair of points for a small number of points.
// Implement a method to find the closest pair of points within a given strip.
// Implement the main algorithm using the divide and conquer approach.
// Sort the points by x-coordinate before starting the algorithm.
// In the main method, create an array of points, sort them
//  and then call the closestPair method to find the closest pair of points.

// Define a Point class to represent points in 2D space
class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class ClosestPairOfPoints {

    // Function to calculate the distance between two points
    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    // Function to find the closest pair of points using brute force
    public static double bruteForceClosestPair(Point[] points, int start, int end) {
        double minDistance = Double.POSITIVE_INFINITY;
        for (int i = start; i <= end; i++) {
            for (int j = i + 1; j <= end; j++) {
                double distance = distance(points[i], points[j]);
                if (distance < minDistance) {
                    minDistance = distance;
                }
            }
        }
        return minDistance;
    }

    // Function to find the closest pair of points in the strip
    public static double closestPairInStrip(Point[] strip, double minDistance) {
        double minStripDistance = minDistance;
        Arrays.sort(strip, Comparator.comparingInt(p -> p.y));
        for (int i = 0; i < strip.length; i++) {
            for (int j = i + 1; j < Math.min(i + 7, strip.length); j++) {
                double distance = distance(strip[i], strip[j]);
                if (distance < minStripDistance) {
                    minStripDistance = distance;
                }
            }
        }
        return minStripDistance;
    }

    // Function to find the closest pair of points using divide and conquer
    public static double closestPair(Point[] points, int start, int end) {
        // Base case: if there are 2 or 3 points, compute the distance directly
        if (end - start <= 2) {
            return bruteForceClosestPair(points, start, end);
        }

        // Divide the set of points into two halves
        int mid = (start + end) / 2;
        Point[] leftHalf = Arrays.copyOfRange(points, start, mid + 1);
        Point[] rightHalf = Arrays.copyOfRange(points, mid + 1, end + 1);

        // Recursively find the closest pair in each half
        double leftClosest = closestPair(leftHalf, 0, leftHalf.length - 1);
        double rightClosest = closestPair(rightHalf, 0, rightHalf.length - 1);

        // Determine the minimum distance among the two halves
        double minDistance = Math.min(leftClosest, rightClosest);

        // Find the closest pair across the dividing line
        List<Point> strip = new ArrayList<>();
        for (Point point : points) {
            if (Math.abs(point.x - points[mid].x) < minDistance) {
                strip.add(point);
            }
        }
        Point[] stripArray = strip.toArray(new Point[0]);
        double closestInStrip = closestPairInStrip(stripArray, minDistance);

        // Return the minimum distance
        return Math.min(minDistance, closestInStrip);
    }

    public static void main(String[] args) {
        // Sample points
        Point[] points = {new Point(2, 3), new Point(12, 30), new Point(40, 50),
                new Point(5, 1), new Point(12, 10), new Point(3, 4)};
        // Sort points by x-coordinate
        Arrays.sort(points, Comparator.comparingInt(p -> p.x));

        // Find the closest pair of points
        double closestDistance = closestPair(points, 0, points.length - 1);
        System.out.println("The closest pair of points has distance: " + closestDistance);
    }
}

