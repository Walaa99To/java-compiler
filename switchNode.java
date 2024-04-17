package ass;

import java.util.ArrayList;
import java.util.HashMap;

public class switchNode extends AbstractTreeNode {
	HashMap<String, Double> temp;
	String id;
	double v;
	public void setValue(double val) {
		this.v=val;}
	public double getValue() {
		return v;}
	public void setId(String g) {
		this.id=g;}
	public String getId() {
		return this.id;}
	@Override
	public Object execute(Context context)
	{  boolean done=false;
		ArrayList<AbstractTreeNode> ch = new ArrayList<AbstractTreeNode>(); 
		double i=0;
		temp=context.getVars();
		if(temp.containsKey(getId())) {
			i=temp.get(getId());}
		aa:
			for(AbstractTreeNode n1 : children) {
			if((Double)n1.execute(context)==i) {
				done=true;
			ch=n1.children;
			for(AbstractTreeNode n : ch) {
				n.execute(context);
				if((String)n.execute(context)=="break")
					break aa ;}
		}else {done=false;}}
			if(!done) {
			ch=children.get(children.size()-1).children;
			for(AbstractTreeNode n : ch) {
				n.execute(context);
				if((String)n.execute(context)=="break")
					break  ;
			}}	return null;}}
