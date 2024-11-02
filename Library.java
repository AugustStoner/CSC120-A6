/* This is a stub for the Library class */
import java.util.Hashtable;

public class Library extends Building{

    private final Hashtable<String, Boolean> collection;

    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      this.collection = new Hashtable<String, Boolean>();
      System.out.println("You have built a library: 📖");
    }
    
    // Methods (modify collection)

    public void addTitle(String title){
      // check that book is not already part of the collection
      //if (this.containsTitle(title)) { throw RuntimeException(title + " is already part of " + this.getName() + "'s collection.");}
      this.collection.put(title, true);
    }

    public String removeTitle(String title){
      // check that book is part of the collection
      //if (!this.containsTitle(title)) { throw RuntimeException(title + " is not part of " + this.getName() + "'s collection.");}
      // check that the book is available
      //if (!this.isAvailable(title)) { throw RuntimeException(title + " is checked out, it cannot be removed at this time.");}
      this.collection.remove(title, true); 
      return title;
    }

    // Methods (modify value/status)

    public void checkOut(String title){
      // check that book is part of the collection
      //if (!this.containsTitle(title)) { throw RuntimeException(title + " is not part of " + this.getName() + "'s collection.");}
      // check that book is available to check out
      
      this.collection.put(title, false);
    }

    public void returnBook(String title){
      // check that book is part of the collection
      //if (!this.containsTitle(title)) { throw RuntimeException(title + " is not part of " + this.getName() + "'s collection.");}
      // check that book has been checked out

      this.collection.put(title, true);
    }

    // Methods (browsing)

    public boolean containsTitle(String title){
      // return true if key exists in collection
      return this.collection.containsKey(title);
    }

    public boolean isAvailable(String title){
      // return true if value is true, false otherwise
      return this.collection.get(title);
    }

    public void printCollection(){
      // prints out the entire collection in an easy-to-read way (including checkout status)
      System.out.println("Books in the " + this.getName() + " Collection:");
      this.collection.forEach((title, value) -> {
        if (this.isAvailable(title)) {
          System.out.println(title + " is available.");
        }
        else {
          System.out.println(title + " is checked out.");
        }
      });
    }

    public String toString() {
      return super.toString();
    }

    public static void main(String[] args) {
      Library neilson = new Library("Neilson Library", "7 Neilson Drive, Northampton, MA 01063", 4);
      neilson.addTitle("Goblin Mode by McKayla Coyle");
      neilson.printCollection();
      neilson.addTitle("Uglies by Scott Westerfeld");

      neilson.addTitle("The Moth Keeper by K. O'Neill");
      //System.out.println(neilson.removeTitle("Goblin Mode by McKayla Coyle"));
      neilson.printCollection();
      System.out.println(neilson.toString());
      System.out.println(neilson.isAvailable("Goblin Mode by McKayla Coyle"));
      neilson.checkOut("Goblin Mode by McKayla Coyle");
      System.out.println(neilson.isAvailable("Goblin Mode by McKayla Coyle"));
      neilson.returnBook("Goblin Mode by McKayla Coyle");
      System.out.println(neilson.isAvailable("Goblin Mode by McKayla Coyle"));
      System.out.println(neilson.containsTitle("Goblin Mode by McKayla Coyle"));
      System.out.println(neilson.removeTitle("Goblin Mode by McKayla Coyle"));
      System.out.println(neilson.containsTitle("Goblin Mode by McKayla Coyle"));

    }
  
  }