package chap11.sec01.List;

import java.util.*;

public class MyVector implements List{
	Object[] data = null;
	int capacity = 0;
	int size = 0;
	
	public MyVector(int cap){
		if(cap<0) throw new IllegalArgumentException("유효하지 않은 값입니다: " + cap);
		this.capacity = cap;
		data = new Object[cap];
	}
	public MyVector() {
		this(10);
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.size==0;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray(Object[] a) {
		Object[] output = new Object[size];
		System.arraycopy(data, 0, output, 0, size);

		return output;
	}

	public void ensureCapacity(int minCapacity) { 
		if(minCapacity - data.length > 0) {
			setCapacity(minCapacity);
		}
	}
	private void setCapacity(int capacity) {
		if(this.capacity==capacity) return;
		
		Object[] tmp = new Object[capacity];
		System.arraycopy(data, 0, tmp, 0, size);
		data = tmp;
		this.capacity = capacity;
	}
	
	@Override
	public boolean add(Object e) {
		if(size==capacity) ensureCapacity(this.capacity*2);
		data[size++] = e;
//		System.out.println(e);
//		System.out.println(data[0]);
		return true;
	}
	public void trimToSize() {
		setCapacity(size);
	}
	@Override
	public Object remove(int idx) {
		Object oldObj = null;
		
		if(idx<0 || idx>=size) {
			throw new IndexOutOfBoundsException("범위를 벗어났습니다.");
		}
		oldObj = data[idx];
		
		if(idx != size-1) {
			System.arraycopy(data, idx+1, data, idx, size-(idx+1));
		}
		data[size-1] = null;
		size--;		
		return oldObj;
	}

	@Override
	public boolean remove(Object o) {
		for(int i=0; i<size; ++i) {
			if(o.equals(data[i])) {
				remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection c) {
		return addAll(size, c);		
	}

	@Override
	public boolean addAll(int index, Collection c) {
		while(c.size() + index+1 > this.capacity) { 
			ensureCapacity(capacity*2);
		}
		//push data
		size = index;

		System.arraycopy(c.toArray(), 0, data, index, c.size());
		size += c.size();
		
		return true;
	}

	@Override
	public boolean removeAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		for(int i=0; i<size; ++i) data[i] = null;
		size = 0;
	}

	@Override
	public Object get(int index) {
		return data[index];
	}

	@Override
	public Object set(int index, Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, Object element) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public Object remove(int index) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer("[");
		for(int i=0; i<size-1; ++i) {
			buf.append(data[i] + ", ");
		}
		buf.append(data[size-1] + "]");
		
		return buf.toString();
	}
	

}
