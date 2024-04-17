package ass;

public class AssignNode extends AbstractTreeNode {
	String type;
	String varName;
	public String getVarName() {
	return varName;
	}
	public void setVarName(String varName) {
	this.varName = varName;
	}
	public String getType() {
		return type;
		}
	public void setType(String type) {
		this.type = type;
		}
	@Override
	public Object execute(Context context) {
		if (getType()=="Double") {
	context.getVars().put(varName, (Double)children.get(0).execute(context));
	System.out.println("Double "+varName+(Double)children.get(0).execute(context));
		}
		if(getType()=="String") {
			context.getVars2().put(varName, (String)children.get(0).execute(context));
		}
		children.get(0).execute(context);
	return null;
	}}

