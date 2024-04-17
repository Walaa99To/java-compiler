package ass;
import java.util.*;
public class inputNode extends AbstractTreeNode
{
	double v;
	String sVal;
	boolean getInt=false;
	boolean getStr=false;
	public void setValue(double val) {
		this.v=val;}
	public double getValue() {
		return v;}
	public void setStrValue(String val) {
		this.sVal=val;}
	public String getStrValue() {
		return sVal;}
	@Override
	public Object execute(Context context) 
	{
		try (Scanner scan = new Scanner(System.in)) {
			if(getInt) {
			int a= scan.nextInt();
			System.out.println("the input is int: "+a);
			setValue(a);
		}
			else if(getStr) {
				String s=scan.next();
				System.out.println("the input is string: "+s);
				setStrValue(s);
			}}
		return null;
	}}
