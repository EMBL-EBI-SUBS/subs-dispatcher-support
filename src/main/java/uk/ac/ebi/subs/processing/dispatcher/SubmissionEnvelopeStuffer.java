package uk.ac.ebi.subs.processing.dispatcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import uk.ac.ebi.subs.processing.SubmissionEnvelope;
import uk.ac.ebi.subs.repository.model.Analysis;
import uk.ac.ebi.subs.repository.model.Assay;
import uk.ac.ebi.subs.repository.model.AssayData;
import uk.ac.ebi.subs.repository.model.EgaDac;
import uk.ac.ebi.subs.repository.model.EgaDacPolicy;
import uk.ac.ebi.subs.repository.model.EgaDataset;
import uk.ac.ebi.subs.repository.model.Project;
import uk.ac.ebi.subs.repository.model.Protocol;
import uk.ac.ebi.subs.repository.model.Sample;
import uk.ac.ebi.subs.repository.model.SampleGroup;
import uk.ac.ebi.subs.repository.model.StoredSubmittable;
import uk.ac.ebi.subs.repository.model.Study;

import java.util.Collection;

/**
 * This helper service function is to add a submittable class to a {@link SubmissionEnvelope}.
 *
 * Created by davidr on 17/07/2017.
 */
@Component
public class SubmissionEnvelopeStuffer {

    private static final Logger logger = LoggerFactory.getLogger(SubmissionEnvelopeStuffer.class);

    public void addAll(SubmissionEnvelope submissionEnvelope, Collection<? extends StoredSubmittable> storedSubmittables) {
        logger.info("Adding {} submittables to envelope {}", storedSubmittables.size(), submissionEnvelope);

        for (StoredSubmittable submittable : storedSubmittables) {
            this.add(submissionEnvelope, submittable);
        }
    }

    public void add(SubmissionEnvelope submissionEnvelope, StoredSubmittable storedSubmittable) {
        //we could make this much nicer, but it works for now
        logger.info("Adding submittable {} to envelope {}", storedSubmittable, submissionEnvelope);

        Class<? extends StoredSubmittable> clazz = storedSubmittable.getClass();

        if (clazz == Analysis.class) {
            this.add(submissionEnvelope, (Analysis) storedSubmittable);
        }
        if (clazz == Assay.class) {
            this.add(submissionEnvelope, (Assay) storedSubmittable);
        }
        if (clazz == AssayData.class) {
            this.add(submissionEnvelope, (AssayData) storedSubmittable);
        }
        if (clazz == EgaDac.class) {
            this.add(submissionEnvelope, (EgaDac) storedSubmittable);
        }
        if (clazz == EgaDacPolicy.class) {
            this.add(submissionEnvelope, (EgaDacPolicy) storedSubmittable);
        }
        if (clazz == EgaDataset.class) {
            this.add(submissionEnvelope, (EgaDataset) storedSubmittable);
        }
        if (clazz == Project.class) {
            this.add(submissionEnvelope, (Project) storedSubmittable);
        }
        if (clazz == Protocol.class) {
            this.add(submissionEnvelope, (Protocol) storedSubmittable);
        }
        if (clazz == Sample.class) {
            this.add(submissionEnvelope, (Sample) storedSubmittable);
        }
        if (clazz == SampleGroup.class) {
            this.add(submissionEnvelope, (SampleGroup) storedSubmittable);
        }
        if (clazz == Study.class) {
            this.add(submissionEnvelope, (Study) storedSubmittable);
        }
    }

    public void add(SubmissionEnvelope submissionEnvelope, Analysis submittable) {
        submissionEnvelope.getAnalyses().add(submittable);
    }

    public void add(SubmissionEnvelope submissionEnvelope, Assay submittable) {
        submissionEnvelope.getAssays().add(submittable);
    }

    public void add(SubmissionEnvelope submissionEnvelope, AssayData submittable) {
        submissionEnvelope.getAssayData().add(submittable);
    }

    public void add(SubmissionEnvelope submissionEnvelope, EgaDac submittable) {
        submissionEnvelope.getEgaDacs().add(submittable);
    }

    public void add(SubmissionEnvelope submissionEnvelope, EgaDacPolicy submittable) {
        submissionEnvelope.getEgaDacPolicies().add(submittable);
    }

    public void add(SubmissionEnvelope submissionEnvelope, EgaDataset submittable) {
        submissionEnvelope.getEgaDatasets().add(submittable);
    }

    public void add(SubmissionEnvelope submissionEnvelope, Project submittable) {
        submissionEnvelope.setProject(submittable);
    }

    public void add(SubmissionEnvelope submissionEnvelope, Protocol submittable) {
        submissionEnvelope.getProtocols().add(submittable);
    }

    public void add(SubmissionEnvelope submissionEnvelope, Sample submittable) {
        submissionEnvelope.getSamples().add(submittable);
    }

    public void add(SubmissionEnvelope submissionEnvelope, SampleGroup submittable) {
        submissionEnvelope.getSampleGroups().add(submittable);
    }

    public void add(SubmissionEnvelope submissionEnvelope, Study submittable) {
        submissionEnvelope.getStudies().add(submittable);
    }
}
