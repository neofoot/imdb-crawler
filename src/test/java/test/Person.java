package test;

public final class Person {
    
    private int age;

    public Person() {
    }

    public Person(int age) {
	this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
	if (obj == null || !Person.class.isInstance(obj)) {
	    return false;
	}
	Person another = (Person) obj;
	return another.getAge() == this.getAge();
    }

    /*@Override
    public int hashCode() {
	return this.getAge();
    }*/

}
