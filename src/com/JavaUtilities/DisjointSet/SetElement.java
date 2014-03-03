package com.JavaUtilities.DisjointSet;

class SetElement<T> {
	
	private T element;
	private SetElement<T> representative;
	private int depth;
	
	public SetElement(T element)
	{
		this.element = element;
	}
	
	public void setRepresentativeElement(SetElement<T> representative)
	{
		this.representative = representative;
	}
	
	public T getElement()
	{
		return this.element;
	}
	
	public SetElement<T> getRepresentativeElement()
	{
		return this.representative;
	}
	
	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}
}
