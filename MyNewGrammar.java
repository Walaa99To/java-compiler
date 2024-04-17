/* Generated By:JavaCC: Do not edit this line. MyNewGrammar.java */
package ass;
public class MyNewGrammar implements MyNewGrammarConstants {
  public static void main(String args []) throws ParseException,java.io.FileNotFoundException
  {
    MyNewGrammar parser = new MyNewGrammar(
      new java.io.FileInputStream("E:/test.txt")
    );
    AbstractTreeNode n = start();
    n.execute(new Context());
  }

  static final public BlockNode start() throws ParseException {
  BlockNode n = new BlockNode();
  AbstractTreeNode c;
    label_1:
    while (true) {
      c = stmt();
                n.addChild(c);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case If:
      case For:
      case While:
      case DO:
      case Switch:
      case Output:
      case Bool:
      case Int:
      case String:
      case Scanner:
      case Id:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
    }
    jj_consume_token(0);
    System.out.println("Tree done");
    {if (true) return n;}
    throw new Error("Missing return statement in function");
  }

  static final public AbstractTreeNode stmt() throws ParseException {
  AbstractTreeNode n;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case If:
      n = ifStmt();
      break;
    case Bool:
    case Int:
    case String:
    case Id:
      n = assignStmt();
      break;
    case While:
      n = whileStmt2();
      break;
    case For:
      n = ForStmt();
      break;
    case DO:
      n = dowhileStmt();
      break;
    case Scanner:
      n = inputStmt();
      break;
    case Output:
      n = outputStmt();
      break;
    case Switch:
      n = switchStmt();
      break;
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  {if (true) return n;}
    throw new Error("Missing return statement in function");
  }

  static final public IfNode ifStmt() throws ParseException {
  IfNode res = new IfNode();
  AbstractTreeNode n=null, nn=null,n1=null;
  BlockNode cn = new BlockNode();
  BlockNode cn2 = new BlockNode();
    jj_consume_token(If);
    jj_consume_token(LeftParenthesis);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case Number:
      n = condition();
      break;
    case Id:
      n = varCondition();
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(RightParenthesis);
    jj_consume_token(LeftBrace);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case Bool:
    case Int:
    case String:
    case Id:
      nn = assignStmt();
    cn.addChild(nn);
  res.addChild(n);
    res.addChild(cn);
      break;
    case BREAK:
    case CONTINUE:
      nn = expr();
      jj_consume_token(Semicolon);
     res.addChild(n);
    res.addChild(nn);
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(RightBrace);
               System.out.println("if done");
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case Else:
      jj_consume_token(Else);
      jj_consume_token(LeftBrace);
      n1 = assignStmt();
      jj_consume_token(RightBrace);
           cn2.addChild(n1);
    res.setbool(true);
    res.addChild(cn2);
      System.out.println("else done");
      break;
    default:
      jj_la1[4] = jj_gen;
      ;
    }
    jj_consume_token(InputEnd);
   {if (true) return res;}
    throw new Error("Missing return statement in function");
  }

  static final public ConditionNode condition() throws ParseException {
  ConditionNode n = new ConditionNode();
  AbstractTreeNode n1,n2;
  Token t;
    n1 = N();
    t = jj_consume_token(Compare);
    n2 = N();
  n.addChild(n1);
  n.addChild(n2);
  n.setOperator(t.image);
  {if (true) return n;}
    throw new Error("Missing return statement in function");
  }

  static final public AssignNode assignStmt() throws ParseException {
  Token t,t1=null,t2=null;
  AssignNode anode = new AssignNode();
  AbstractTreeNode n;
  whileNode wRes=new whileNode();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case Id:
      t = jj_consume_token(Id);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case Assignment:
        t1 = jj_consume_token(Assignment);
        break;
      case IncDec:
        t2 = jj_consume_token(IncDec);
        break;
      default:
        jj_la1[5] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case Number:
        n = N();
          anode.setType("Double");
        break;
      case StringQuat:
        n = StrN();
                                                   anode.setType("String");
        break;
      case True:
      case False:
        n = BoolN();
                                                                                             anode.setType("Boolean");
        break;
      default:
        jj_la1[6] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      jj_consume_token(Semicolon);
 anode.setVarName(t.image);
  anode.addChild(n);
  {if (true) return anode;}
      break;
    case String:
      jj_consume_token(String);
      t = jj_consume_token(Id);
      jj_consume_token(Assignment);
      n = StrN();
                                                 anode.setType("String");
      jj_consume_token(Semicolon);
  anode.setVarName(t.image);
  anode.addChild(n);
  {if (true) return anode;}
      break;
    case Int:
      jj_consume_token(Int);
      t = jj_consume_token(Id);
      jj_consume_token(Assignment);
      n = N();
                                          anode.setType("Double");
      jj_consume_token(Semicolon);
  anode.setVarName(t.image);
  anode.addChild(n);
  {if (true) return anode;}
      break;
    case Bool:
      jj_consume_token(Bool);
      t = jj_consume_token(Id);
      jj_consume_token(Assignment);
      n = BoolN();
                                               anode.setType("String");
      jj_consume_token(Semicolon);
  anode.setVarName(t.image);
  anode.addChild(n);
  {if (true) return anode;}
      break;
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public varCondNode varCondition() throws ParseException {
  varCondNode n = new varCondNode();
  AbstractTreeNode n1,n2;
  Token t,t1;
    t1 = jj_consume_token(Id);
    t = jj_consume_token(Compare);
    n2 = N();
  n.addChild(n2);
  n.setStr(t1.image);
  n.setOperator(t.image);
  {if (true) return n;}
    throw new Error("Missing return statement in function");
  }

  static final public ConstantNode N() throws ParseException {
 Token t1,t2=null,t3=null;
    t1 = jj_consume_token(Number);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case Plus:
      t2 = jj_consume_token(Plus);
      t3 = jj_consume_token(Number);
      break;
    default:
      jj_la1[8] = jj_gen;
      ;
    }
   ConstantNode cn = new ConstantNode();
      if (t2==null && t3==null) {
      cn.setValue(Double.parseDouble(t1.image));
       }
      else {
        switch (t2.image) {
        case "+":
        cn.setValue((Double.parseDouble(t1.image)+Double.parseDouble(t3.image)));
        break;
        case "-":
        cn.setValue((Double.parseDouble(t1.image)-Double.parseDouble(t3.image)));
        break;
        case "*":
        cn.setValue((Double.parseDouble(t1.image)*Double.parseDouble(t3.image)));
        break;
        case "/":
        cn.setValue((Double.parseDouble(t1.image)/Double.parseDouble(t3.image)));
        break;}}
      {if (true) return cn;}
    throw new Error("Missing return statement in function");
  }

  static final public ConstantNode StrN() throws ParseException {
 Token t=null;
    jj_consume_token(StringQuat);
    t = jj_consume_token(Id);
    jj_consume_token(StringQuat);
      ConstantNode cn = new ConstantNode();
      cn.setStrValue(t.image);
      {if (true) return cn;}
    throw new Error("Missing return statement in function");
  }

  static final public ConstantNode BoolN() throws ParseException {
 Token t1=null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case True:
      t1 = jj_consume_token(True);
      break;
    case False:
      jj_consume_token(False);
      break;
    default:
      jj_la1[9] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
      ConstantNode cn = new ConstantNode();
      cn.setStrValue(t1.image);
      {if (true) return cn;}
    throw new Error("Missing return statement in function");
  }

  static final public whileNode whileStmt2() throws ParseException {
whileNode wRes=new whileNode();
AbstractTreeNode ATN1,ATN2;
 BlockNode cn = new BlockNode();
 Token t1=null,t=null,t2=null,t3=null,t4=null;
    jj_consume_token(While);
    jj_consume_token(LeftParenthesis);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case Id:
      t1 = jj_consume_token(Id);
      t = jj_consume_token(Compare);
      t2 = jj_consume_token(Number);
      break;
    case True:
      t3 = jj_consume_token(True);
      break;
    case False:
      t4 = jj_consume_token(False);
      break;
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  if (t3==null && t4==null) {
      ATN1=vV(t1,t,t2); }
      else if (t1==null && t3==null) {ATN1=TorF("false"); }
      else { ATN1=TorF("true"); }
    jj_consume_token(RightParenthesis);
    jj_consume_token(LeftBrace);
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case Bool:
      case Int:
      case String:
      case Id:
        ATN2 = assignStmt();
        break;
      case For:
        ATN2 = ForStmt();
        break;
      case While:
        ATN2 = whileStmt2();
 cn.addChild(ATN2);
wRes.addChild(ATN1);
    wRes.addChild(cn);
        break;
      case If:
        ATN2 = ifStmt();
 wRes.addChild(ATN1);
    wRes.addChild(ATN2);
        break;
      default:
        jj_la1[11] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case If:
      case For:
      case While:
      case Bool:
      case Int:
      case String:
      case Id:
        ;
        break;
      default:
        jj_la1[12] = jj_gen;
        break label_2;
      }
    }
    jj_consume_token(RightBrace);
    jj_consume_token(InputEnd);
    if(t3==null&& t4==null) {
    wRes.setCondValue(Double.parseDouble(t2.image));
    wRes.setStr(t1.image); }
    else{
      wRes.setCondValue(600000000);}
    System.out.println("While done");
    {if (true) return wRes;}
    throw new Error("Missing return statement in function");
  }

  static final public varCondNode vV(Token t1,Token t,Token t2) throws ParseException {
  varCondNode n = new varCondNode();
  AbstractTreeNode n1,n2;
  n2 = N1(t2);
n.addChild(n2);
  n.setStr(t1.image);
  n.setOperator(t.image);
  {if (true) return n;}
    throw new Error("Missing return statement in function");
  }

  static final public ConstantNode N1(Token t) throws ParseException {
      ConstantNode cn = new ConstantNode();
      cn.setValue(Double.parseDouble(t.image));
      {if (true) return cn;}
    throw new Error("Missing return statement in function");
  }

  static final public TorFCondNode TorF(String b) throws ParseException {
    TorFCondNode tf=new TorFCondNode();
if(b=="true") {
tf.setType("true"); }
else {
  tf.setType("false"); }
{if (true) return tf;}
    throw new Error("Missing return statement in function");
  }

  static final public forNode ForStmt() throws ParseException {
forNode fRes=new forNode();
AbstractTreeNode ATN1,ATN2;
 BlockNode cn = new BlockNode();
 Token t1,t,t2,t3,t4,t5,t6=null,t7=null;
    jj_consume_token(For);
    jj_consume_token(LeftParenthesis);
    t1 = jj_consume_token(Id);
    jj_consume_token(Assignment);
    t2 = jj_consume_token(Number);
    jj_consume_token(Semicolon);
    t1 = jj_consume_token(Id);
    t = jj_consume_token(Compare);
    t3 = jj_consume_token(Number);
    jj_consume_token(Semicolon);
    t1 = jj_consume_token(Id);
    t4 = jj_consume_token(IncDec);
    t5 = jj_consume_token(Number);
  ATN1=forCond(t2,t3,t);
fRes.addChild(ATN1);
fRes.setVStr(t1.image);
    jj_consume_token(RightParenthesis);
    jj_consume_token(LeftBrace);
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case Bool:
      case Int:
      case String:
      case Id:
        ATN2 = assignStmt();
  cn.addChild(ATN2);
    fRes.addChild(cn);
        break;
      case For:
        ATN2 = ForStmt();
  cn.addChild(ATN2);
    fRes.addChild(cn);
        break;
      case While:
        ATN2 = whileStmt2();
  cn.addChild(ATN2);
    fRes.addChild(cn);
        break;
      case If:
        ATN2 = ifStmt();
  fRes.addChild(ATN2);
     fRes.setAddIF();
        break;
      default:
        jj_la1[13] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case If:
      case For:
      case While:
      case Bool:
      case Int:
      case String:
      case Id:
        ;
        break;
      default:
        jj_la1[14] = jj_gen;
        break label_3;
      }
    }
    jj_consume_token(RightBrace);
    jj_consume_token(InputEnd);
    fRes.setInitValue(Double.parseDouble(t2.image));
    fRes.setFinValue(Double.parseDouble(t3.image));
    fRes.setOperator(t4.image);
    fRes.setIncDecVal(Double.parseDouble(t5.image));
    System.out.println("for done");
    {if (true) return fRes;}
    throw new Error("Missing return statement in function");
  }

  static final public ConditionNode forCond(Token t1,Token t2,Token t3) throws ParseException {
 ConditionNode n = new ConditionNode();
  AbstractTreeNode n1,n2;
  Token t;
  n1 =N1(t1);
  n2 = N1(t2);
  n.addChild(n1);
  n.addChild(n2);
  n.setOperator(t3.image);
  {if (true) return n;}
    throw new Error("Missing return statement in function");
  }

  static final public doWhileNode dowhileStmt() throws ParseException {
doWhileNode dwRes=new doWhileNode();
AbstractTreeNode ATN1=null,ATN2=null;
 BlockNode cn = new BlockNode();
Token t1=null,t=null,t2=null,t3=null,t4=null;
    jj_consume_token(DO);
    jj_consume_token(LeftBrace);
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case Bool:
      case Int:
      case String:
      case Id:
        ATN2 = assignStmt();
                                           cn.addChild(ATN2);
 dwRes.addChild(cn);
        break;
      case For:
        ATN2 = ForStmt();
                    cn.addChild(ATN2);
 dwRes.addChild(cn);
        break;
      case While:
        ATN2 = whileStmt2();
                     cn.addChild(ATN2);
 dwRes.addChild(cn);
        break;
      case If:
        ATN2 = ifStmt();
 dwRes.addChild(ATN2);
        break;
      default:
        jj_la1[15] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case If:
      case For:
      case While:
      case Bool:
      case Int:
      case String:
      case Id:
        ;
        break;
      default:
        jj_la1[16] = jj_gen;
        break label_4;
      }
    }
    jj_consume_token(RightBrace);
    jj_consume_token(While);
    jj_consume_token(LeftParenthesis);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case Id:
      t1 = jj_consume_token(Id);
      t = jj_consume_token(Compare);
      t2 = jj_consume_token(Number);
      break;
    case True:
      t3 = jj_consume_token(True);
      break;
    case False:
      t4 = jj_consume_token(False);
      break;
    default:
      jj_la1[17] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(RightParenthesis);
      if (t3==null && t4==null) {
      ATN1=vV(t1,t,t2); }
      else if (t1==null && t3==null) {ATN1=TorF("false"); }
      else { ATN1=TorF("true"); }
    jj_consume_token(InputEnd);
    dwRes.addChild(ATN1);
    if(t3==null&& t4==null) {
    dwRes.setCondValue(Double.parseDouble(t2.image));
    dwRes.setStr(t1.image); }
    else{
      dwRes.setCondValue(600000000);}
    System.out.println("doWhile done");
    {if (true) return dwRes;}
    throw new Error("Missing return statement in function");
  }

  static final public inputNode inputStmt() throws ParseException {
  inputNode in=new inputNode();
  AbstractTreeNode ATN1,ATN2;
 BlockNode cn = new BlockNode();
 Token t1,t,t2;
    jj_consume_token(Scanner);
    t1 = jj_consume_token(Id);
    jj_consume_token(Assignment);
    jj_consume_token(New);
    jj_consume_token(Scanner);
    jj_consume_token(LeftParenthesis);
    jj_consume_token(Input);
    jj_consume_token(RightParenthesis);
    jj_consume_token(Semicolon);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case String:
      jj_consume_token(String);
      jj_consume_token(Id);
      jj_consume_token(Assignment);
      t1 = jj_consume_token(Id);
      jj_consume_token(Dot);
      jj_consume_token(Next);
      jj_consume_token(LeftParenthesis);
      jj_consume_token(RightParenthesis);
      jj_consume_token(Semicolon);
                                                                                                                 in.getStr=true;
    {if (true) return in;}
      break;
    case Int:
      jj_consume_token(Int);
      jj_consume_token(Id);
      jj_consume_token(Assignment);
      t1 = jj_consume_token(Id);
      jj_consume_token(Dot);
      jj_consume_token(NextInt);
      jj_consume_token(LeftParenthesis);
      jj_consume_token(RightParenthesis);
      jj_consume_token(Semicolon);
                                                                                                                 in.getInt=true;
    {if (true) return in;}
      break;
    default:
      jj_la1[18] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public outputNode outputStmt() throws ParseException {
  outputNode out=new outputNode();
  AbstractTreeNode ATN1,ATN2;
 BlockNode cn = new BlockNode();
 Token t=null,t1=null,t2;
    jj_consume_token(Output);
    jj_consume_token(LeftParenthesis);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 42:
      jj_consume_token(42);
      t = jj_consume_token(Id);
      jj_consume_token(42);
  out.setStrValue(t.image);
      break;
    case Number:
      t1 = jj_consume_token(Number);
   out.setValue(Double.parseDouble(t1.image));
      break;
    default:
      jj_la1[19] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(RightParenthesis);
    jj_consume_token(Semicolon);
 {if (true) return out;}
    throw new Error("Missing return statement in function");
  }

  static final public switchNode switchStmt() throws ParseException {
  switchNode sw=new switchNode();
  AbstractTreeNode ATN1,ATN2;
Token t1,t2;
    jj_consume_token(Switch);
    jj_consume_token(LeftParenthesis);
    t1 = jj_consume_token(Id);
    jj_consume_token(RightParenthesis);
    jj_consume_token(LeftBrace);
    label_5:
    while (true) {
      ATN1 = caseEX();
 System.out.println("switch done");
  sw.addChild(ATN1);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case Case:
        ;
        break;
      default:
        jj_la1[20] = jj_gen;
        break label_5;
      }
    }
    ATN2 = defaultEX();
                   sw.addChild(ATN2);
    jj_consume_token(RightBrace);
 sw.setId(t1.image);
  {if (true) return sw;}
    throw new Error("Missing return statement in function");
  }

  static final public caseNode caseEX() throws ParseException {
caseNode c=new caseNode();
AbstractTreeNode ATN1=null,nn=null;
 BlockNode cn = new BlockNode();
  Token t1,t2=null;
    jj_consume_token(Case);
    t1 = jj_consume_token(Number);
    jj_consume_token(DoubleDot);
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case Bool:
      case Int:
      case String:
      case Id:
        ;
        break;
      default:
        jj_la1[21] = jj_gen;
        break label_6;
      }
      ATN1 = assignStmt();
                                                          cn.addChild(ATN1); c.addChild(cn);
    }
    nn = expr();
    jj_consume_token(Semicolon);
  c.addChild(nn);
  c.setVal(Double.parseDouble(t1.image));
{if (true) return c;}
    throw new Error("Missing return statement in function");
  }

  static final public defaultNode defaultEX() throws ParseException {
defaultNode d=new defaultNode();
AbstractTreeNode ATN1=null,nn=null;
 BlockNode cn = new BlockNode();
  Token t1,t2=null;
    jj_consume_token(Default);
    jj_consume_token(DoubleDot);
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case Bool:
      case Int:
      case String:
      case Id:
        ;
        break;
      default:
        jj_la1[22] = jj_gen;
        break label_7;
      }
      ATN1 = assignStmt();
                                               cn.addChild(ATN1); d.addChild(cn);
    }
    nn = expr();
    jj_consume_token(Semicolon);
  d.addChild(nn);
{if (true) return d;}
    throw new Error("Missing return statement in function");
  }

  static final public exprNode expr() throws ParseException {
  exprNode ex=new exprNode();
Token t5=null,t6=null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case BREAK:
      t5 = jj_consume_token(BREAK);
      break;
    case CONTINUE:
      t6 = jj_consume_token(CONTINUE);
      break;
    default:
      jj_la1[23] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  if(t6==null) {
    ex.isbreak=true;
  ex.setStrValue("break"); }
  if(t5==null) { ex.setStrValue("continue");}
{if (true) return ex;}
    throw new Error("Missing return statement in function");
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public MyNewGrammarTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[24];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0xf239200,0xf239200,0x40,0x7006000,0x400,0x80,0xc00040,0x7000000,0x20,0xc00000,0xc00000,0x7009200,0x7009200,0x7009200,0x7009200,0x7009200,0x7009200,0xc00000,0x6000000,0x40,0x40000,0x7000000,0x7000000,0x6000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x200,0x200,0x200,0x200,0x0,0x100,0x10,0x200,0x0,0x0,0x200,0x200,0x200,0x200,0x200,0x200,0x200,0x200,0x0,0x400,0x0,0x200,0x200,0x0,};
   }

  /** Constructor with InputStream. */
  public MyNewGrammar(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public MyNewGrammar(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new MyNewGrammarTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 24; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 24; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public MyNewGrammar(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new MyNewGrammarTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 24; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 24; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public MyNewGrammar(MyNewGrammarTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 24; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(MyNewGrammarTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 24; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[43];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 24; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 43; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
