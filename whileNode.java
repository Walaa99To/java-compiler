package ass;

import java.util.HashMap;

public class whileNode extends AbstractTreeNode 
{	HashMap<String, Double> temp;
	double v;
	String s;
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
		double i=0;
		temp=context.getVars();
		if(temp.containsKey(getStr())) {
			i=temp.get(getStr());
		while ((Boolean)children.get(0).execute(context) && i<getValue()) {
			children.get(1).execute(context);
			System.out.println("Innnnnwhile was built successfully!");
			i++;
			context.getVars().put("i", i++);
			setCondValue((getValue()));
			if((String)children.get(1).execute(context)=="break") {
				break;
			}
			if((String)children.get(1).execute(context)=="continue") {
				continue;
			}}}
		return null;}}


