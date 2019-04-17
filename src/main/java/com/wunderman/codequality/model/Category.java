package com.wunderman.codequality.model;

public class Category {
	 	private String name;
	 	private String description;
	    private String id;
	    private String uri;
	    private Boolean online;
	    private Boolean special;
	    private Boolean showOnSite;

	public Boolean getSubcategoriesAvailable() {
		return subcategoriesAvailable;
	}

	public void setSubcategoriesAvailable(Boolean subcategoriesAvailable) {
		this.subcategoriesAvailable = subcategoriesAvailable;
	}

	private Boolean subcategoriesAvailable;

	public Boolean getShowOnSite() {
		return showOnSite;
	}

	public void setShowOnSite(Boolean showOnSite) {
		this.showOnSite = showOnSite;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getSpecial() {
		return special;
	}

	public void setSpecial(Boolean special) {
		this.special = special;
	}

	public Boolean getOnline() {
		return online;
	}

	public void setOnline(Boolean online) {
		this.online = online;
	}

	public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getUri() {
			return uri;
		}

		public void setUri(String uri) {
			this.uri = uri;
		}

	    
}
