public class Homework3 {
    public static void main (String[]args){

        /*
        Intersection predicate takes four points a, b, c, and d, which define two line segments,
        ab and cd, and decides if the two line segments have a "T" intersection, meaning
        that the two points intersect in exactly one point, and the point p is interior to one
        of the segments and is an endpoint of the other segment.
         */

        //int x = 0;
        //int y = 1;
        //each point is an array with an x and y coordinate.
        int[] a = new int[2];
        int[] b = new int[2];
        int[] c = new int[2];
        int[] d = new int[2];

        //test case
        //int[] a = {1, 1};
        //int[] b = {4, 1};
        //int[] c = {2, 1};
        //int[] d = {2, 10};
        System.out.print(TIntersect(a, b, c, d));

    }


    public static boolean TIntersect(int[] a, int[] b, int[] c, int[] d){
        /*
        Three of the four endpoints HAVE to be collinear for a T intersection
        Proper intersection: when two segments intersect at a point interior to both (we need interior to only one)
        We need improper intersection!

        I'll check if any point is in between the other two points.
        If this is true, to ensure it is interior to that line, I'll make sure it's not a proper intersection.
         */

        //a is collinear with the line cd
        //a is in between c & d
        if(Between(c, d, a) && !IntersectProp(a, b, c, d)){
            return true;
        }
        //b is collinear with the line cd
        //b is in between c & d
        else if(Between(c, d, b) && !IntersectProp(a, b, c, d)){
            return true;
        }
        //c is collinear with the line ab
        //c is in between a & b
        else if(Between(a, b, c) && !IntersectProp(a, b, c, d)){
            return true;
        }
        //d is collinear with the line ab
        //d is in between a & b
        else if(Between(a, b, d) && !IntersectProp(a, b, c, d)) {
            return true;
        } else {
            return false;
        }
    }


    public static int Area2(int[] a, int[] b, int[] c){
        int x = 0;
        int y = 1;
        return ((b[x] - a[x]) * (c[y] - a[y])) - ((c[x] - a[x]) * (b[y] - a[y]));
    }


    public static boolean Left(int[] a, int[] b, int[] c){
        return Area2(a, b, c) > 0;
    }

    //public static boolean LeftOn(int[] a, int[] b, int[] c){
    //    return Area2(a, b, c) >= 0;
    //}

    public static boolean Collinear(int[] a, int[] b, int[] c){
        return Area2(a, b, c) == 0;
    }

    public static boolean IntersectProp(int[] a, int[] b, int[] c, int[] d){
        if (Collinear(a,b,c) || Collinear(a,b,d) || Collinear(c, d, a) || Collinear(c, d, b)) {
            return false;
        }
        return Xor(Left(a, b, c), Left(a, b, d)) && Xor(Left(c, d, a), Left(c, d, b));
    }

    public static boolean Xor(boolean x, boolean y){
        return !x ^ !y;
    }

    public static boolean Between(int[] a, int[] b, int[] c){

        int x = 0;
        int y = 1;

        if (!Collinear(a, b, c)){
            return false;
        }

        if(a[x] != b[x]){
            return ((a[x] <= c[x]) && (c[x] <= b[x])) || ((a[x] >= c[x]) && (c[x] >= b[x]));
        } else {
            return ((a[y] <= c[y]) && (c[y] <= b[y])) || ((a[y] >= c[y]) && (c[y] >= b[y]));
        }
    }

    //public static boolean Intersect(int[] a, int[] b, int[] c, int[] d){
    //    if (IntersectProp(a, b, c, d)){
    //        return true;
    //    } else if (Between(a, b, c) || Between(a, b, d) || Between(c, d, a) || Between(c, d, b)){
    //        return true;
    //    } else {
    //        return false;
    //    }
    //}
}