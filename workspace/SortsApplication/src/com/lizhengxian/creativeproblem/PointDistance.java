package com.lizhengxian.creativeproblem;

import java.util.Comparator;

import edu.princeton.cs.algs4.Point2D;

public class PointDistance  {
    public static class Xcomparator implements Comparator<Point2D>{
		@Override
		public int compare(Point2D o1, Point2D o2) {
			// TODO Auto-generated method stub
			Double x1 = o1.x();
			Double x2 = o2.x();
			return x1.compareTo(x2);
		}
    }
    public static class Ycomparator implements Comparator<Point2D>{
		@Override
		public int compare(Point2D o1, Point2D o2) {
			// TODO Auto-generated method stub
			Double y1 = o1.y();
			Double y2 = o2.y();
			return y1.compareTo(y2);
		}
    }
    public static class Rcomparator implements Comparator<Point2D>{
		@Override
		public int compare(Point2D o1, Point2D o2) {
			// TODO Auto-generated method stub
			Double r1 = o1.r();
			Double r2 = o2.r();
			return r1.compareTo(r2);
		}
    }
    
}
