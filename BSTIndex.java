/*
 THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
 CODE WRITTEN BY OTHER STUDENTS. Caroline Zhang
 */

public class BSTIndex {
    
    public class Node {
        
        String key;
        MovieInfo data;
        Node left;
        Node right;
        
        public Node (MovieInfo x) {
        
            this.key = x.shortName;
            this.data = x;
            this.left = null;
            this.right = null;
            
        }
        
    }
    
    public Node root;
    public Node parent;
	
    public BSTIndex () {
        // constructor to initialize the BST. The data element should be an object of the type MovieInfo, described above
        
        root = null;
        
    }
    
    public MovieInfo findExact (String key) {
        // return the data element MovieInfo where the shortName matches the key exactly (can have different capitalization)
        
        /*inorder(root);
        System.out.println ("abe vs ben leggo");
        int q = CompareToEx("BEN", "aBe");
        System.out.println(q);
        System.out.println ("abe vs caro leggo");
        int w = CompareToEx("aBe", "Caro");
        System.out.println(w);
        System.out.println ("abe vs abe leggo");
        int e = CompareToEx("aBe", "ABE");
        System.out.println(e); */
        
        Node x = root;
        
        //System.out.println("x left same as root left?");
        //System.out.println(x.left == root.left);
        
        //System.out.println(x.key);
        
        int i = 0;
        String keycap = Capitalization(key);

        
        while ( x != null) {
            //System.out.println("findExact loop");
            String xcap = Capitalization(x.key);
            
            if (CompareToEx(keycap, xcap) == 0) {
                //System.out.println("it's a match!");
                return x.data;
            }
            if (CompareToEx(keycap, xcap) == 1) {
                x = x.right; // this part doesn't work
                //System.out.println("input is later in the alphabet");
            }
            if (CompareToEx(keycap, xcap) == -1) {
                //String s1 = x.key;
                //System.out.println("key for x before right is " + s1);
                
                x = x.left; //  this part doesn't work
               // System.out.println("input is earlier in the alphabet");

                
                //s1 = x.key;
                //System.out.println("key for x after right is " + s1);
                //System.out.println("-1");

            }
            i++;
        }
        
        System.out.println("counter " + i);

        return null;
    
    }
    
    public MovieInfo findPrefix (String prefix) {
        // return the data element MovieInfo where the shortName starts with the prefix (can have different capitalization)
        
        Node x = root;
        
        int i = 0;
        String prefixcap = Capitalization(prefix);

        while ( x!= null) {
            //System.out.println("findPrefix loop");
            String xcap = Capitalization(x.key);
            
            if (CompareToPre(prefixcap, xcap) == 0) {
                return x.data;
            }
            if (CompareToPre(prefixcap, xcap) == 1) {
                x = x.right; // right side is for the values towards z on the alphabet
                //System.out.println(x.right.key);
            }
            if (CompareToPre(prefixcap, xcap) == -1) {
                x = x.left; // left side if for values closer to a on the alphabet
                //System.out.println(x.right.key);
            }
            i++;
        }
        
        System.out.println("counter " + i);

        return null;
        
        
    }
    
    public void insert (MovieInfo data) {
        
        root = insert (root, data);
        return;
    }
    
    public void inorder(Node x) {
        if (x == null) {
            return;
        }
            
        inorder (x.left);
        System.out.println(x.key);
        inorder(x.right);
    }
    
    public Node insert (Node x, MovieInfo data) {
        // insert the given data element into the proper place in the BST structure
        
        if (x == null) {
            return new Node(data);
        }
        
        if (CompareToEx(data.shortName, x.key) == 1) {
            //String tree = x.key;
            //String input = data.shortName;
            //System.out.println("entry in tree is " + tree);
            //System.out.println("name of input is " + input);
            x.right = insert(x.right, data);
        }
        
        if (CompareToEx(data.shortName, x.key) == -1) {
            //String tree = x.key;
            //String input = data.shortName;
            //System.out.println("entry in tree is " + tree);
            //System.out.println("name of input is " + input);
            x.left = insert(x.left, data);
        }
        
        if (CompareToEx(data.shortName, x.key) == 0) {
            //String tree = x.key;
            //String input = data.shortName;
            //System.out.println("entry in tree is " + tree);
            //System.out.println("name of input is " + input);
            x.data = data;
        }
        
        return x;
        
    }
    
    public int CompareToPre(String k, String x) {
        // comparable to compare the two objects to see if they match up
        
        // System.out.println("CompareTo function");
    
        int minlength = 0;
        
        if (x.length() >= k.length()-1) {
            minlength = k.length()-1;
        } else {
            minlength = x.length();
        }
        
        for (int i = 0; i < minlength; i++) {
            
            if (x.charAt(i) < k.charAt(i)) {
                //System.out.println("1");
                return 1;
            }
            
            if (x.charAt(i) > k.charAt(i)) {
                //System.out.println("-1");
                return -1;
            }
            
        }
        
        if (x.length() < k.length()-1) {
            return 1;
        }
        if (k.length()-1 > x.length()) {
            return -1;
        }
        
        //System.out.println("0");
        return 0;
        
    }
    
    public int CompareToEx(String k, String x) {
        // comparable to compare the two objects to see if they match up
        
        // System.out.println("CompareTo function");
        
        if (k.equalsIgnoreCase(x)) {
            return 0;
        }
        
        int minlength = 0;
        
        if (x.length() >= k.length()) {
            minlength = k.length();
        } else {
            minlength = x.length();
        }
        
        for (int i = 0; i < minlength; i++) {
            
            //char h = x.charAt(i);
            //char j = k.charAt(i);
            //System.out.println("tree character at " + i + " is " + h);
            //System.out.println("input character at " + i + " is " + j);
            
            if (x.charAt(i) < k.charAt(i)) {
                //System.out.println("1");
                return 1;
            }
            
            if (x.charAt(i) > k.charAt(i)) {
                //System.out.println("-1");
                return -1;
            }
            
        }
        
        if (x.length() < k.length()) {
            //System.out.println("input string is longer");
            return 1; // if they put in a prefix by accident, this should catch it
        }
        if (x.length() > k.length()) {
            //System.out.println("tree string is longer");
            return -1;
        }
        
        //System.out.println("0");
        return 0;
    }
    
    public String Capitalization (String a) {
        
        //System.out.println("Capitalization function");
        
        String acap = a.toUpperCase();
        
        /*
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) > 95) {
                acap += (a.charAt(i) - 32);
            } else {
                acap += a.charAt(i);
            }
        }
        */
        
        //System.out.println(a);
        //System.out.println(acap);
        
        
        return acap;
        
    }
    
    
    

}
















