package project.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import project.service.RegistrationService;
import project.domain.User;

import com.google.common.collect.Lists;

@ManagedBean
@SessionScoped
public class RegistrationManagedBean {

	private User user = new User();

	private List<User> users = new ArrayList<User>();

	@ManagedProperty(value = "#{registrationService}")
	private RegistrationService service = new RegistrationService();

	public void onRowSelect(SelectEvent event) {

	}

	/**
	 * 
	 * @return
	 */
	public String createNewUser() {
		setUser(new User());
		return "";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		this.users = Lists.newArrayList(this.service.getRepository().findAll());
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public RegistrationService getService() {
		return service;
	}

	public void setService(RegistrationService service) {
		this.service = service;
	}

/**
 * Yeni kullanici girisi ve guncelleme islemlerini yapar
 * @return
 */
	public String register() {
		FacesMessage msg = null;

		if (this.user == null || "".equals(this.user.getName())
				|| this.user.getName() == null) {
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR",
					"Name is can not be null");
			FacesContext.getCurrentInstance().addMessage(null, msg);

		}
		if (this.user == null || "".equals(this.user.getSurName())
				|| this.user.getSurName() == null) {
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR",
					"Surname is can not be null");
			FacesContext.getCurrentInstance().addMessage(null, msg);

		}

		if (msg == null) {

			this.service.getRepository().save(user);
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correct",
					"New customer has been saved");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			setUser(new User());
		}

		return "1";
	}

	/**
	 * Secilen user'i silme islemini yapar
	 * @param user
	 * @return
	 */
	public String delete(User user) {
		this.service.getRepository().delete(user);
		setUser(new User());
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Correct", "Customer has been deleted");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		return "";
	}

	/**
	 * User secme islemini yapar.
	 * @param user
	 * @return
	 */
	public String update(User user) {
		setUser(user);
		return "";
	}

}
