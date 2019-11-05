/* Animal Shelter: An animal shelter, which holds only dogs and cats, operates
 * on a strictly "first in, first out" basis.  People must adopt either the
 * "oldest" (based on arrival time) of all animals at the shelter, or they
 * can select whether they would prefer a dog or a cat (and will receive the
 * oldest animal of that type).  They cannot select which specific animal they
 * would like.  Create the data structures to maintain this system and implement
 * operations such as enqueue, dequeueAny, dequeueDog, and dequeueCat.  You may
 * use the built-in LinkedList data structure.
 *
 *
 * Current solution time complexity = ???
 */

import java.util.*; 
  
abstract class Animal { 
    private int order;
    protected String name;
    public Animal(String n) {
        name = n;
    }
    public void setOrder(int ord) {
        order = ord;
    }
    public int getOrder() {
        return order;
    }

    // compare orders of animals to return the older item
    public boolean isOlderThan(Animal a) {
        return this.order < a.getOrder();
    }
}

class AnimalQueue {
    LinkedList<Dog> dogs = new LinkedList<Dog>();
    LinkedList<Cat> cats = new LinkedList<Cat>();
    private int order = 0; // acts as a timestamp

    public void enqueue(Animal a) {
        // order is used as a sort of timestamp, so that we can
        // compare the insertion order of a dog to a cat
		a.setOrder(order);
		order++;
		if (a instanceof Dog) {
			dogs.addLast((Dog) a);
		} else if (a instanceof Cat) {
			cats.addLast((Cat)a);
		}
	}
	
	public Animal dequeueAny() {
        // look at tops of dog and cat queues, and pop the queue
        // with the oldest value
		if (dogs.size() == 0) {
			return dequeueCats();
		} else if (cats.size() == 0) {
			return dequeueDogs();
		}
		Dog dog = dogs.peek();
		Cat cat = cats.peek();
		if (dog.isOlderThan(cat)) {
			return dogs.poll();
		} else {
			return cats.poll();
		}
	}
	
	public Animal peek() {
		if (dogs.size() == 0) {
			return cats.peek();
		} else if (cats.size() == 0) {
			return dogs.peek();
		}
		Dog dog = dogs.peek();
		Cat cat = cats.peek();
		if (dog.isOlderThan(cat)) {
			return dog;
		} else {
			return cat;
		}
	}
	
	public int size() {
		return dogs.size() + cats.size();
	}
	
	public Dog dequeueDogs() {
		return dogs.poll();
	}
	
	public Dog peekDogs() {
		return dogs.peek();
	}
	
	public Cat dequeueCats() {
		return cats.poll();
	}
	
	public Cat peekCats() {
		return cats.peek();
	}
}

class Dog extends Animal {
    public Dog(String n) {
        super(n);
    }
}

class Cat extends Animal {
    public Cat(String n) {
        super(n);
    }
}



