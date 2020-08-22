package bo.custom;

import bo.SuperBO;
import util.ShowBooksTM;
import util.ShowMembersTM;

import java.util.Date;
import java.util.List;

public interface IssueBO extends SuperBO {
    public String getNewIssueId() throws Exception;
    public boolean issueBook(String id, String member_id, String book_id, Date issueDate) throws Exception;
    public List<ShowBooksTM> getAllBooks() throws Exception;
    public List<ShowMembersTM> getAllMembers() throws Exception;
}
