package ass;

import java.util.HashMap;

public class varCondNode extends AbstractTreeNode {
	HashMap<String, Double> temp;
	String operator;
	String s;
	public String getOperator() {
	return operator;}
	public void setOperator(String operator) {
	this.operator = operator;}
	public void setStr(String g) {
		this.s=g;}
	public String getStr() {
		return s;}
	@Override
	public Object execute(Context context) {
		double i=0;
		temp=context.getVars();
		if(temp.containsKey(getStr())) {
			i=temp.get(getStr());
	double d2 = (Double)children.get(0).execute(context);
	switch(operator) {
	case ">":
	return i > d2;
	case "<":
	return i < d2;
	case "==":
	return i == d2;
	}}
	return null;
	}}