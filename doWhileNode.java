package ass;

import java.util.HashMap;

public class doWhileNode extends AbstractTreeNode 
{
	double v;
	String s;
	HashMap<String, Double> temp;
	public void setCondValue(double val) {
		this.v=val;}
	public double getValue() {
		return v;}
	public void setStr(String g) {
		this.s=g;}
	public String getStr() {
		return s;}
	@Override
	public Object execute(Context context) 
	{
		int len=children.size()-1;
		children.get(1).execute(context);
		double i=0;
		temp=context.getVars();
		if(temp.containsKey(getStr())) {
			i=temp.get(getStr());
		while ((Boolean)children.get(len).execute(context) && i<getValue()) {
			children.get(len-1).execute(context);
			System.out.println("In dowhile was built successfully!");
			i++;
			context.getVars().put("i", i++);
			setCondValue((getValue()));
			if((String)children.get(len-1).execute(context)=="break") {
				break;
			}
			if((String)children.get(len-1).execute(context)=="continue") {
				continue;
			}
		}}
		return null;}}