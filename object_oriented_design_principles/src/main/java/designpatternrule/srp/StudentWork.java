package designpatternrule.srp;

public class StudentWork {
    //life Guidance生活指导
    public void lifeGuidance(Counselors counselors) {
        counselors.attendanceStatistics();
        counselors.classCommitteeConstruction();
        counselors.classManagement();
        counselors.psychologicalCounseling();
        counselors.feeCollection();
    }

    //academic Guidance学业指导
    public void academicGuidance(AcademicTutor academicTutor) {
        academicTutor.learningGuidance();
        academicTutor.learningSummary();
        academicTutor.professionalGuidance();
        academicTutor.scientificResearchGuidance();
    }
}
