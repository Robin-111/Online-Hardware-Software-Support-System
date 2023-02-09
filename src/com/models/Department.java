package com.models;

public class Department {
	 
		private int deptid;
		private String dName;
		private String location;
		public Department() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Department(int deptid, String dName, String location) {
			super();
			this.deptid = deptid;
			this.dName = dName;
			this.location = location;
		}
		public int getDeptid() {
			return deptid;
		}
		public void setDeptid(int deptid) {
			this.deptid = deptid;
		}
		public String getdName() {
			return dName;
		}
		public void setdName(String dName) {
			this.dName = dName;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		@Override
		public String toString() {
			return "Department [deptid=" + deptid + ", dName=" + dName + ", location=" + location + "]";
		}
		
}
