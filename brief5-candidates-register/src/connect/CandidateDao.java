package connect;

import java.util.Set;

public interface CandidateDao {
  Set<Candidate> getAllCandidates();
  boolean insertCandidate(Candidate candidate);
  boolean getCandiate(int id);
  boolean updateCandidate(int id, Candidate candidate);
  boolean deleteCandidate(int id);
}