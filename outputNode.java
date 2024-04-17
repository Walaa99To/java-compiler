package ass;

public class outputNode extends AbstractTreeNode
{
	double v=Double.POSITIVE_INFINITY;
	String str=null;
	public void setValue(double val) {
		this.v=val;
	}
	public double getValue() {
		return v;
		}
	public void setStrValue(String val) {
		this.str=val;
	}
	public String getStrValue() {
		return str;
		}
	@Override
	public Object execute(Context context) 
	{
		if(getValue()==Double.POSITIVE_INFINITY) {
			System.out.println(getStrValue());
		}
		else if(getStrValue()==null) {
			System.out.println(getValue());
		}
		else {
			System.out.println(getValue()+" "+getStrValue());
		}
		return null;
	}
}
