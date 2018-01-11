package Api.service;

import Api.model.SubProject;
import Api.persistence.SubProjectDao;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.awt.*;
import java.util.ArrayList;

@Singleton
public class SubProjectService extends BaseService<SubProject> {
    private final SubProjectDao subProjectDao;
    ArrayList<SubProject> subProjectArrayList;
    
    @Inject
    public SubProjectService(SubProjectDao subProjectDao){
        this.subProjectDao = subProjectDao;
    }
    public void updateSubProjectName(TextField oldText, TextField newText)
    {
        getArraylist();
        for (SubProject sub: subProjectArrayList)
        {
            if (sub.getSubProject_Name().equals(oldText.getText()));
            {
                sub.setSubProject_Name(newText.getText());
                subProjectDao.setUpdateSubProjectName(sub);
                break;
            }
        }
    }
    public SubProject getSubProjectById(int subProjectId){
        return subProjectDao.getSubProjectById(subProjectId);
    }
    public void createSubProject(String subProjectName, int subProject_Project_Number){
        SubProject subProject = new SubProject(subProjectName, subProject_Project_Number);
        subProjectDao.insertSubProject(subProject);
    }
    public boolean checkIfSubprojectExists(String subProjectName){

        return subProjectDao.checkIfSubprojectExists(subProjectName);

    }
    public ArrayList<SubProject> getArraylist()
    {
        return subProjectArrayList = subProjectDao.getsubProjectArrayList();

    }
    public int getSubProjectNumber(String subProject_Name){

        return subProjectDao.getSpecificSubProject(subProject_Name).getSubProject_Number();

    }
}
