package ass;

public class ConstantNode extends AbstractTreeNode {
	boolean doubleChange=false;
	boolean strChange=false;
	boolean boolChage=false;
	double value;
	boolean b=false;
	String str=null;
	public double getValue() {
	return value;}
	public void setValue(double value) {
	this.value = value;
	doubleChange=true;}
	public String getStrValue() {
	return str;}
	public void setStrValue(String value) {
	this.str=value;
	strChange=true;}
	public boolean getBoolValue() {
	return b;}
	public void setBoolValue(boolean value) {
	this.b=value;
	boolChage=true;}
	@Override
	public Object execute(Context context) {
		if(strChange) {
			return getStrValue();
		}else if(doubleChange) {
			return getValue();
		}else {
			return getBoolValue();
		}}}

