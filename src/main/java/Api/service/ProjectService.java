package Api.service;

import Api.model.Project;
import Api.persistence.ProjectDao;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class ProjectService extends BaseService<Project>{
    private final ProjectDao projectDao;

    @Inject
    public ProjectService(ProjectDao projectDao){
        this.projectDao = projectDao;
    }

    public void createProject(String project_name, String project_client_name){
        Project project = new Project(project_name, project_client_name);
        projectDao.insertProject(project);

    }

    public ArrayList<Project> selectAllProjects(){
        return projectDao.selectAllProjects();
    }


    public boolean checkProjectExist(String project_name){
        if(projectDao.checkProjectExist(project_name)){
            return true;
        }
        else{
            return false;
        }
    }

    public int getProjectNumber(String project_name){
        return projectDao.getSpecificProject(project_name).getProject_Number();

    }
}
