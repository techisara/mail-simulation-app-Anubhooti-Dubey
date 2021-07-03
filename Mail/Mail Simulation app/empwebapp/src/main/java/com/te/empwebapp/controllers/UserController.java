package com.te.empwebapp.controllers;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.te.empwebapp.beans.Mail;
import com.te.empwebapp.beans.User;
import com.te.empwebapp.service.MailService;
import com.te.empwebapp.service.UserService;
@Controller
public class UserController {




	

		@InitBinder
		public void initBinder(WebDataBinder binder) {
			System.out.println("init Binder");
			CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
			binder.registerCustomEditor(Date.class, editor);
		}
		
		@Autowired
		private UserService service;
		
		@Autowired
		private MailService service2;

		@GetMapping("/login")
		public String getEmpForm() {
			return "empLogin";
		}// getEmpForm

		@PostMapping("/loginm")
		public String authenticate(String email, String password, HttpServletRequest request, ModelMap map) {
			User user = service.authenticate(email, password);
			System.out.println(user);
			if (user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("loggedIn", user);
//				session.setMaxInactiveInterval(3600);
				map.addAttribute("name", user.getUserName());
				return "employeeHome";
			} else {
				map.addAttribute("errMsg", "Invalid Credentials");
				return "empLogin";
			}
		}// authenticate

//		@GetMapping("/searchPage")
//		public String getSearchPage(HttpSession session, ModelMap map) {
//			EmployeeInfoBean infoBean = (EmployeeInfoBean) session.getAttribute("loggedIn");
//			System.out.println(infoBean);
//			if (infoBean != null) {
//				System.out.println("valid");
//				return "empSearchPage";
//			} else {
//				map.addAttribute("errMsg", "Please Login First");
//				return "empLogin";
//			}
//		}// getSearchPage
//
//		@GetMapping("/search")
//		public String getEmployeeData(int id,
//				@SessionAttribute(name = "loggedIn", required = false) EmployeeInfoBean infoBean, ModelMap map) {
//			if (infoBean != null) {
//				EmployeeInfoBean employeeInfoBean = service.getEmployeeData(id);
//				if (employeeInfoBean != null) {
//					map.addAttribute("empData", employeeInfoBean);
//				} else {
//					map.addAttribute("errMsg", "Data not Found");
//				}
//				return "empSearchPage";
//			} else {
//				map.addAttribute("errMsg", "Please Login First");
//				return "empLogin";
//			}
//		}
//
		@GetMapping("/logout")
		public String logout(HttpSession session, ModelMap map) {
			session.invalidate();
			map.addAttribute("msg", "logout successfull");
			return "empLogin";
		}// logout
//
//		@GetMapping("/getDeleteForm")
//		public String getDeleteForm(@SessionAttribute(name = "loggedIn", required = false) EmployeeInfoBean infoBean,
//				ModelMap map) {
//			if (infoBean != null) {
//				return "deleteEmp";
//			} else {
//				map.addAttribute("errMsg", "Please Login First");
//				return "empLogin";
//			}
//		}//
//
//		@GetMapping("/delete")
//		public String deleteData(int id, @SessionAttribute(name = "loggedIn", required = false) EmployeeInfoBean infoBean,
//				ModelMap map) {
//			if (infoBean != null) {
//				if (service.deleteEmpData(id)) {
//					map.addAttribute("msg", "Data Deleted successfully for id : " + id);
//				} else {
//					map.addAttribute("msg", "Could not find Record for id : " + id);
//				}
//				return "deleteEmp";
//			} else {
//				map.addAttribute("errMsg", "Please Login First");
//				return "empLogin";
//			}
//
//		}//
//
		@GetMapping("/addEmp")
		public String getAddFrom() 
			{
		
				return "insertEmployee";
			

		}//

		@PostMapping("/add")
		public String addEmployee( User user, ModelMap map) {
			if (user != null) {
				if (service.addEmployee(user)) {
					map.addAttribute("msg", "Successfully Inserted");
				} else {
					map.addAttribute("msg", "Failed to Insert");
					return "insertEmployee";
				}
				return "empLogin";
			} else {
				map.addAttribute("errMsg", "Failed to Insert");
				return "insertEmployee";
			}

		}// add Employee
//
//		@GetMapping("/updateEmployee")
//		public String getUpadatePage(@SessionAttribute(name = "loggedIn", required = false) EmployeeInfoBean infoBean,
//				ModelMap map) {
//			if (infoBean != null) {
//				map.addAttribute("id", infoBean);
//				return "updateEmployee";
//			} else {
//				map.addAttribute("errMsg", "Please Login First");
//				return "empLogin";
//
//			}
//		}//
//
//		@PostMapping("/update")
//		public String updateEmployeeData(@SessionAttribute(name = "loggedIn", required = false) EmployeeInfoBean infoBean,
//				ModelMap map, EmployeeInfoBean employeeInfoBean) {
//			if (infoBean != null) {
//				if (service.updateRecord(employeeInfoBean)) {
//					map.addAttribute("msg", "Updated Successfully");
//					map.addAttribute("id", employeeInfoBean);
//				} else {
//					map.addAttribute("msg", "Updation Failed");
//					map.addAttribute("id", infoBean);
//				}
//				return "updateEmployee";
//			} else {
//				map.addAttribute("errMsg", "Please Login First");
//				return "empLogin";
//			}
//		}//
//
		@GetMapping("/getAll")
		public String getAllRecords(@SessionAttribute(name = "loggedIn", required = false) Mail mails,
				ModelMap map) {
			if (mails != null) {
				List<Mail> mail = service2.getAllEmployees();
				if (mail != null) {
					
					map.addAttribute("infos", mail);
				}else {
					map.addAttribute("errMsg", "No Records Found");
				}
				map.addAttribute("name", mails.getMesssage());	
				return "employeeHome";
			} else {
				map.addAttribute("errMsg", "Please Login First");
				return "empLogin";
			}
		}

	}


