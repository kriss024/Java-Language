class MyClass implements Cloneable {
		private String name;
	
        public MyClass(String name) {
        	this.name = name;
        }
        
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
        public String getName() {
        	return this.name;
        }
    }


public class Main {

	public static void main(String[] args) {
		MyClass original = new MyClass("Human Resource");
		System.out.println(original.getName());
		
		MyClass cloned = null;
		
		try {
			cloned = (MyClass)original.clone();
		} catch (CloneNotSupportedException e) {
			System.err.println(e.getMessage());
		}
		
		System.out.println(cloned.getName());

	}

}
