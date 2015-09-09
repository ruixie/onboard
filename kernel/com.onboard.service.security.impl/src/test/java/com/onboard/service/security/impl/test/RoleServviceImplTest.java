package com.onboard.service.security.impl.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.onboard.domain.mapper.UserCompanyMapper;
import com.onboard.domain.mapper.UserMapper;
import com.onboard.domain.mapper.UserProjectMapper;
import com.onboard.domain.mapper.model.UserCompanyExample;
import com.onboard.domain.mapper.model.UserProjectExample;
import com.onboard.domain.mapper.model.common.BaseExample;
import com.onboard.domain.model.Company;
import com.onboard.domain.model.CompanyPrivilege;
import com.onboard.domain.model.Project;
import com.onboard.domain.model.ProjectPrivilege;
import com.onboard.domain.model.User;
import com.onboard.service.account.CompanyService;
import com.onboard.service.account.UserService;
import com.onboard.service.collaboration.ProjectService;
import com.onboard.service.security.CompanyPrivilegeService;
import com.onboard.service.security.ProjectPrivilegeService;
import com.onboard.service.security.impl.RoleServiceImpl;
import com.onboard.test.exampleutils.CriterionVerifier;
import com.onboard.test.exampleutils.ExampleMatcher;
import com.onboard.test.exampleutils.ObjectMatcher;
import com.onboard.test.moduleutils.ModuleHelper;

public class RoleServviceImplTest {
    @InjectMocks
    private RoleServiceImpl roleServiceImpl;

    @Mock
    private CompanyService companyService;

    @Mock
    private UserService userService;

    @Mock
    private ProjectService projectService;

    @Mock
    private CompanyPrivilegeService companyPrivilegeService;

    @Mock
    private ProjectPrivilegeService projectPrivilegeService;

    @Mock
    private UserProjectMapper userProjectMapper;

    @Mock
    private UserCompanyMapper userCompanyMapper;

    @Mock
    private UserMapper userMapper;

    private Company company;

    private Project project;

    private CompanyPrivilege companyPrivilege;

    private ProjectPrivilege projectPrivilege;

    private User user;

    @Before
    public void setUpBefore() throws Exception {
        project = ModuleHelper.getASampleProject();
        company = ModuleHelper.getASampleCompany();
        user = ModuleHelper.getASampleUser();
        user.setId(ModuleHelper.creatorId);
        companyPrivilege = new CompanyPrivilege();
        companyPrivilege.setCompanyId(company.getId());
        companyPrivilege.setUserId(user.getId());
        companyPrivilege.setIsAdmin(true);
        companyPrivilege.setCanCreateProject(false);
        projectPrivilege = new ProjectPrivilege();
        projectPrivilege.setProjectId(project.getId());
        projectPrivilege.setUserId(user.getId());
        projectPrivilege.setIsAdmin(false);
        when(companyService.getById(Matchers.argThat(new ObjectMatcher<Integer>() {
            @Override
            public boolean verifymatches(Integer item) {
                return item.equals(company.getId());
            }
        }))).thenReturn(company);
        when(projectService.getById(Matchers.argThat(new ObjectMatcher<Integer>() {
            @Override
            public boolean verifymatches(Integer item) {
                return item.equals(project.getId());
            }
        }))).thenReturn(project);
        when(userService.isUserInProject(any(Integer.class), any(Integer.class), any(Integer.class))).thenReturn(true);
    }

    @Test
    public void testCompanyOwner() {
        boolean result = roleServiceImpl.companyOwner(user.getId(), company.getId());
        assertEquals(result, true);
    }

    @Test
    public void testCompanyAdmin() {
        boolean result = roleServiceImpl.companyAdmin(user.getId(), company.getId());
        assertEquals(result, true);
    }

    @Test
    public void testCompanyMemberCanCreateProject() {
        boolean result = roleServiceImpl.companyMemberCanCreateProject(user.getId(), company.getId());
        assertEquals(result, true);
    }

    @Test
    public void testProjectAdmin() {
        boolean result = roleServiceImpl.projectAdmin(user.getId(), company.getId(), project.getId());
        assertEquals(result, true);
    }

    @Test
    public void testCompanyAdminInSpecificProject() {
        boolean result = roleServiceImpl.companyAdminInSpecificProject(user.getId(), company.getId(), project.getId());
        assertEquals(result, true);
    }

    @Test
    public void testProjectMember() {
        roleServiceImpl.projectMember(user.getId(), company.getId(), project.getId());
        verify(userProjectMapper).countByExample(argThat(new ExampleMatcher<UserProjectExample>() {
            @Override
            public boolean matches(BaseExample example) {
                return CriterionVerifier.verifyEqualTo(example, "companyId", company.getId())
                        && CriterionVerifier.verifyEqualTo(example, "projectId", project.getId())
                        && CriterionVerifier.verifyEqualTo(example, "userId", user.getId());
            }
        }));

    }

    @Test
    public void testProjectCreator() {
        boolean result = roleServiceImpl.projectCreator(user.getId(), project.getId());
        assertEquals(result, true);
    }

    @Test
    public void testCompanyMember() {
        roleServiceImpl.companyMember(user.getId(), company.getId());
        verify(userCompanyMapper).countByExample(argThat(new ExampleMatcher<UserCompanyExample>() {
            @Override
            public boolean matches(BaseExample example) {
                return CriterionVerifier.verifyEqualTo(example, "companyId", company.getId())
                        && CriterionVerifier.verifyEqualTo(example, "userId", user.getId());
            }
        }));
    }

    @Test
    public void testGetCompanyOwnerByCompanyId() {
        roleServiceImpl.getCompanyOwnerByCompanyId(company.getId());
        verify(userMapper).selectByPrimaryKey(argThat(new ObjectMatcher<Integer>() {
            @Override
            public boolean verifymatches(Integer item) {
                return item.equals(user.getId());
            }
        }));
    }

    @Test
    public void testGetProjectMembersByProjectId() {
        roleServiceImpl.getProjectMembersByProjectId(project.getId());
        verify(userProjectMapper).selectByExample(argThat(new ExampleMatcher<UserProjectExample>() {
            @Override
            public boolean matches(BaseExample example) {
                return CriterionVerifier.verifyEqualTo(example, "projectId", project.getId());
            }
        }));
    }

    @Test
    public void testGetCompanyMembersByCompanyId() {
        roleServiceImpl.getCompanyMembersByCompanyId(company.getId());
        verify(userCompanyMapper).countByExample(argThat(new ExampleMatcher<UserCompanyExample>() {
            @Override
            public boolean matches(BaseExample example) {
                return CriterionVerifier.verifyEqualTo(example, "companyId", company.getId())
                        && CriterionVerifier.verifyEqualTo(example, "userId", user.getId());
            }
        }));
    }

    @Test
    public void testGetCompanyAdminsByCompanyId() {
        roleServiceImpl.getCompanyAdminsByCompanyId(company.getId());
        verify(companyPrivilegeService).getCompanyPrivilegesByExample(argThat(new ObjectMatcher<CompanyPrivilege>() {
            @Override
            public boolean verifymatches(CompanyPrivilege item) {
                return item.getCompanyId().equals(company.getId()) && item.getIsAdmin();
            }
        }), any(Integer.class), any(Integer.class));
        RoleServiceImpl roleServiceImplSpy = Mockito.spy(roleServiceImpl);
        verify(roleServiceImplSpy).getCompanyOwnerByCompanyId(company.getId());
    }

    @Test
    public void testGetCompanyAdminsByCompanyIdInSpecificProject() {
        List<User> users = new ArrayList<User>();
        users.add(user);
        RoleServiceImpl roleServiceImplSpy = Mockito.spy(roleServiceImpl);
        doReturn(users).when(roleServiceImplSpy).getCompanyAdminsByCompanyId(company.getId());
        roleServiceImpl.getCompanyAdminsByCompanyIdInSpecificProject(company.getId(), project.getId());
        verify(roleServiceImplSpy).getCompanyAdminsByCompanyId(company.getId());
        verify(roleServiceImplSpy).projectMember(user.getId(), company.getId(), project.getId());
    }

    @Test
    public void testGetProjectAdminsByProjectId() {
        RoleServiceImpl roleServiceImplSpy = Mockito.spy(roleServiceImpl);
        roleServiceImpl.getProjectAdminsByProjectId(project.getId());
        verify(projectPrivilegeService).getProjectPrivilegesByExample(argThat(new ObjectMatcher<ProjectPrivilege>() {
            @Override
            public boolean verifymatches(ProjectPrivilege item) {
                return item.getProjectId().equals(project.getId()) && item.getIsAdmin();
            }
        }), any(Integer.class), any(Integer.class));
        verify(roleServiceImplSpy).getCompanyAdminsByCompanyId(project.getCompanyId());

    }
}