package ass;

public class forNode extends AbstractTreeNode 
{   double initV;
	double finV;
	String operator;
	double incDec;
	double i=0;
	double count=0;
	boolean addIf=false;
	String id;
	public void setInitValue(double val) {
		this.initV=val;}
	public double getInitValue() {
		return initV;}
	public void setFinValue(double val) {
		this.finV=val;}
	public double getFinValue() {
		return finV;}
	public String getOperator() {
		return operator;}
	public void setOperator(String operator) {
		this.operator = operator;}
	public void setIncDecVal(double val) {
		this.incDec=val;}
	public double getIncDecVal() {
		return incDec;}
	public void addcount(int a) {
		i+=a;}
	public void setC() {
		this.count=this.count+1;}
	public void setAddIF() {
		this.addIf=true;}
	public void setVStr(String g) {
		this.id=g;}
	public String getId() {
		return this.id;}
	@Override
	public Object execute(Context context) 
	{
	int len=children.size();
	
	context.getVars().put(getId(), getInitValue());
	switch(operator) {
	case "+=":
		while ((Boolean)children.get(0).execute(context) && getInitValue()<getFinValue()) {
			children.get(len-1).execute(context);
			System.out.println("done");
			setInitValue((getInitValue()+getIncDecVal()));
			i++;
			context.getVars().put(getId(), getInitValue());
			if((String)children.get(len-1).execute(context)=="break") {
				break;
			}
			if((String)children.get(len-1).execute(context)=="continue") {
				continue;
			}}
	case "-=":
		while ((Boolean)children.get(0).execute(context) && getInitValue()>getFinValue()) {
			children.get(1).execute(context);
			System.out.println("done");
			setInitValue((getInitValue()-getIncDecVal()));
			i--;
			if((String)children.get(1).execute(context)=="break") {
				break;
			}
			if((String)children.get(1).execute(context)=="continue") {
				continue;
			}}}
		return null;}}

