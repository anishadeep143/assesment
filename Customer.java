package asses2;

public class Customer implements Comparable{
private int eid;
private String ename;
private String email;
private int no;
Customer(){}

public int getEid() {
	return eid;
}
public void setEid(int eid) {
	this.eid = eid;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getNo() {
	return no;
}
public void setNo(int no) {
	this.no = no;
}
public Customer(int eid, String ename, String email, int no) {
	super();
	this.eid = eid;
	this.ename = ename;
	this.email = email;
	this.no = no;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + eid;
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + ((ename == null) ? 0 : ename.hashCode());
	result = prime * result + no;
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Customer other = (Customer) obj;
	if (eid != other.eid)
		return false;
	if (email == null) {
		if (other.email != null)
			return false;
	} else if (!email.equals(other.email))
		return false;
	if (ename == null) {
		if (other.ename != null)
			return false;
	} else if (!ename.equals(other.ename))
		return false;
	if (no != other.no)
		return false;
	return true;
}
@Override
public String toString() {
	return "Customer [eid=" + eid + ", ename=" + ename + ", email=" + email + ", no=" + no + "]";
}

@Override
public int compareTo(Object o) {
	Customer c=(Customer)o;
	
	return c.getEid()-this.getEid();
}

}

