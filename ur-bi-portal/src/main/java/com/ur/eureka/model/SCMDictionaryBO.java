package com.ur.eureka.model;

public class SCMDictionaryBO {
	//键
		private String skey;
		
		//值
		private String svalue;
		
		//父键
		private String parentKey;
		
		//组code
		private String sgroup;
		
		//父组code
		private String parentSgroup;
		
		//排序
		private Integer sort;
		
		//备注
		private String description;
		
		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}


		public Integer getSort() {
			return sort;
		}

		public void setSort(Integer sort) {
			this.sort = sort;
		}

		public String getSgroup() {
			return sgroup;
		}

		public void setSgroup(String sgroup) {
			this.sgroup = sgroup;
		}

		public String getParentSgroup() {
			return parentSgroup;
		}

		public void setParentSgroup(String parentSgroup) {
			this.parentSgroup = parentSgroup;
		}

		public String getSkey() {
			return skey;
		}

		public void setSkey(String skey) {
			this.skey = skey;
		}

		public String getSvalue() {
			return svalue;
		}

		public void setSvalue(String svalue) {
			this.svalue = svalue;
		}

		public String getParentKey() {
			return parentKey;
		}

		public void setParentKey(String parentKey) {
			this.parentKey = parentKey;
		}
}
