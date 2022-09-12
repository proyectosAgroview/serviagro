package co.com.arcosoft.presentation.backingBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean(name = "idleMonitor")
public class IdleMonitorView {

	private String onActiveIdle = "on";

	public void onActive() {

		FacesContext context = FacesContext.getCurrentInstance();
		Object attribute = context.getExternalContext().getSessionMap().get("treeEventsView");

		if (attribute != null) {
			context.getExternalContext().getSessionMap().remove("menuService");
			context.getExternalContext().getSessionMap().remove("treeEventsView");
		}

	}

	public String getOnActiveIdle() {
		return onActiveIdle;
	}

	public void setOnActiveIdle(String onActiveIdle) {
		this.onActiveIdle = onActiveIdle;
	}

}
