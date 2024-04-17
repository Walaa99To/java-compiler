package ass;

public class caseNode extends AbstractTreeNode {
	double v;
	public void setVal(double val) {
		this.v=val;
	}
	public double getVal() {
		return v;
		}
	public Object execute(Context context) 
	{
		return getVal();
	}
}
