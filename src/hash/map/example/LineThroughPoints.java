package hash.map.example;

import java.math.BigInteger;
import java.util.*;
class LineThroughPoints{
	static class Point{
	int x=0,y=0;
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
	}
	public static int findLineWithMostPoints(List<Point> points) {
		
		
		int maxPoints=0;
		for( int i=0; i<points.size(); i++) {
			Point prev= points.get(i);
			HashMap<Integer, HashMap<Integer,Integer>> slopeMap = new HashMap<Integer, HashMap<Integer,Integer>>();
			int duplicate=1;
			for(int j=i+1; j<points.size(); j++) {
				Point curr = points.get(j);
				if(curr.x ==prev.x && curr.y == prev.y) ++duplicate;
				int xDiff  = Math.abs(prev.x - curr.x);
				int yDiff = Math.abs(prev.y - curr.y);
				if(xDiff ==0)yDiff=1;
				int gcd = BigInteger.valueOf(xDiff).gcd(BigInteger.valueOf(yDiff)).intValue();
				xDiff /= gcd;
				yDiff /=gcd;
				slopeMap.putIfAbsent(xDiff, new HashMap<Integer,Integer>());
				slopeMap.get(xDiff).put(yDiff,slopeMap.get(xDiff).getOrDefault(yDiff,0)+1);
				
			}
			maxPoints = Math.max(maxPoints, 
					duplicate + (slopeMap.isEmpty()?0:
						Collections.max(
								Collections.max(slopeMap.values(),
												Comparator.comparingInt(m -> Collections.max(m.values()))).values()
						)));
		}
		return maxPoints;
	}
	
	public static void main(String args[]){
		
		List<Point> points = new ArrayList<Point>();
				points.add(new Point(1,1));
				points.add(new Point(3,2));
				points.add(new Point(5,3));
				points.add(new Point(4,1));
				points.add(new Point(2,3));
				points.add(new Point(1,4));
		System.out.println(findLineWithMostPoints(points));
	}

}

