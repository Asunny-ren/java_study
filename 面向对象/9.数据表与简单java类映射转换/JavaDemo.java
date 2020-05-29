class Member{
  private String mid;
  private String name;
  private Role roles [];
  public Member(String mid, String name) {
    this.mid = mid;
    this.name = name;
  }
  public void setRoles (Role roles []) {
    this.roles = roles;
  }
  public Role [] getRoles () {
    return this.roles;
  }
  public String getInfo () {
    return "【用户信息】: 编号：" + this.mid + "、姓名：" + this.name;
  }
}

class Role{
  private long rid;
  private String title;
  private Member members [];
  private Privilege privileges [];
  public Role (long rid, String title) {
    this.rid = rid;
    this.title = title;
  }
  public void setMembers (Member members []) {
    this.members = members;
  }
  public Member [] getMembers () {
    return this.members;
  }
  public void setPrivileges (Privilege privileges []) {
    this.privileges = privileges;
  }
  public Privilege [] getPrivileges () {
    return this.privileges;
  }
  public String getInfo () {
    return "【角色信息】: 编号：" + this.rid + "、名称：" + this.title;
  }
}

class Privilege{
  private long pid;
  private String title;
  private Role role;
  public Privilege(long pid, String title) {
    this.pid = pid;
    this.title = title;
  }
  public void setRole (Role role) {
    this.role = role;
  }
  public Role getRole () {
    return this.role;
  }
  public String getInfo () {
    return "【权限信息】: 编号：" + this.pid + "、名称：" + this.title;
  }
}
public class JavaDemo {
  public static void main(String args []) {
    // 第一步根据结构设置对象数据
    Member memA = new Member("lll-a", "rjd");
    Member memB = new Member("lll-b", "rdd");
    Role roleA = new Role (1L, "manager");
    Role roleB = new Role (2L, "audit");
    Role roleC = new Role (3L, "business");
    Privilege priA = new Privilege(1001L, "系统初始化");
    Privilege priB = new Privilege(1002L, "系统还原");
    Privilege priC = new Privilege(1003L, "系统环境修改");
    Privilege priD = new Privilege(2001L, "备份员工数据");
    Privilege priE = new Privilege(2002L, "备份部门数据");
    Privilege priF = new Privilege(2003L, "备份公文数据");
    Privilege priG = new Privilege(3001L, "增加员工 ");
    Privilege priH = new Privilege(3002L, "编辑员工");
    Privilege priI = new Privilege(3003L, "查看员工");
    Privilege priJ = new Privilege(3004L, "删除员工");
    // 增加角色与权限的对应关系
    roleA.setPrivileges(new Privilege [] {priA, priB, priC});
    roleB.setPrivileges(new Privilege [] {priD, priE, priF});
    roleC.setPrivileges(new Privilege [] {priG, priH, priI, priJ});
    // 增加权限与角色对应关系
    priA.setRole(roleA);
    priB.setRole(roleA);
    priC.setRole(roleA);
    priD.setRole(roleB);
    priE.setRole(roleB);
    priF.setRole(roleB);
    priG.setRole(roleC);
    priH.setRole(roleC);
    priI.setRole(roleC);
    priJ.setRole(roleC);
    // 增加用户和角色对应关系
    memA.setRoles(new Role [] {roleA, roleB});
    memB.setRoles(new Role [] {roleA, roleB,  roleC });
    // 增加角色和用户对应关系
    roleA.setMembers(new Member [] {memA, memB});
    roleB.setMembers(new Member [] {memA, memB});
    roleC.setMembers(new Member [] {memB});
    // 第二步，根据要求获取数据
    System.out.println("----------通过用户查找信息-----------");
    System.out.println(memA.getInfo());
    for(Role x : memA.getRoles()) {
      System.out.println("\t|-" + x.getInfo());
      for(Privilege y : x.getPrivileges()) {
        System.out.println("\t\t|-" + y.getInfo());
      }
    }
    System.out.println("----------通过角色查找信息-----------");
    System.out.println(roleA.getInfo());
    for(Privilege x : roleA.getPrivileges()){
      System.out.println("\t|-" + x.getInfo());
    }
    for(Member x : roleA.getMembers()){
      System.out.println("\t|-" + x.getInfo());
    }
    System.out.println("----------通过权限查找信息-----------");
    System.out.println(priA.getInfo());
    System.out.println(priA.getRole().getInfo());
    for(Member x :  priA.getRole().getMembers()) {
      System.out.println("\t|-" + x.getInfo());
    }
  }
}