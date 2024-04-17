package ass;

public class TorFCondNode extends AbstractTreeNode {
	String type;
	public String getType() {
		return type;
		}
	public void setType(String type) {
		this.type = type;
		}
	public Object execute(Context context) {
		if(getType()=="true") {
		return Boolean.TRUE;}
		else {
			return Boolean.FALSE;
		}
		}
	}

