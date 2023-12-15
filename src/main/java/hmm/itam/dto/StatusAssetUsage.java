package hmm.itam.dto;

public enum StatusAssetUsage {

    업무용("업무용"),
    공용("공용"),
    대여용("대여용"),
    기타("기타");

        private final String description;

    StatusAssetUsage(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
