package pers.xiaolong;

public class VersionUtils {

    public static final int BIGGER = 1;
    public static final int SMALLER = -1;
    public static final int EQUAL = 0;
    public static final int INPUT_NOT_VALID = -100;
    public static final int COMPATIBLE = 1;
    public static final int NOT_COMPATIBLE = 0;
    /*
     * 比较版本号大小
     * @param version1 版本号1
     * @param version2 版本号2
     * @return 版本号1>版本号2 返回1;
     *         版本号1<版本号2 返回-1;
     *         版本号1=版本号2 返回0
     *
     */
    public static int compare(String version1, String version2){

        if(!isValid(version1) || !isValid(version2) ){
            return INPUT_NOT_VALID;
        }
        Version first = convert(version1);
        Version second = convert(version2);
        if(first == null || second == null) {
            return INPUT_NOT_VALID;
        }
        return first.compareTo(second);
    }
    /*
     * 判断是否兼容
     * @param version1 版本号1
     * @param version2 版本号2
     * @return 兼容返回1 不兼容返回2
     */
    public static int isCompatible(String version1, String version2){
        if(!isValid(version1) || !isValid(version2) ){
            return INPUT_NOT_VALID;
        }
        Version first = convert(version1);
        Version second = convert(version2);
        if(first == null || second == null) {
            return INPUT_NOT_VALID;
        }
        return first.isCompatible(second);
    }

    /*
     * 判断输入是否合法
     * @param version 版本号
     * @return 合法返回true 不合法返回false
     */
    private static boolean isValid(String version) {
        if( version==null || version =="") {
            printNotValid(version, "null");
            return false;
        }
        if(!version.contains(".")){
            printNotValid(version, "not contains .");
            return false;
        }

        return true;
    }

    /*
     * 将String转为Version
     * @param version 版本号
     * @return 若输入合法返回Version 不合法返回null
     */
    private static Version convert(String version) {
        String numbers[] = version.split("\\.");
        if(numbers.length != 2){
            printNotValid(version, "more than one .");
            return null;
        }
        Integer stable = null;
        Integer beta = null;
        try {
            stable = Integer.valueOf(numbers[0]);
            beta = Integer.valueOf(numbers[1]);
        }catch ( Exception e){
            printNotValid(version, "contains other characters");
        }
        if(stable == null || beta == null) {
            return null;
        }
        return new Version(stable,beta);
    }



    /*
     * 输出不合法版本号与原因
     * @param version 版本号
     * @param reason 不合法原因
     */
    private static void printNotValid(String version, String reason) {
        System.out.println(version + " is not valid: " + reason);
    }

    static class Version{
        private int stable;
        private int beta;
        public Version(Integer stable, Integer beta){
            this.stable = stable;
            this.beta = beta;
        }
        public int compareTo(Version version){
            if(stable!=version.stable){
                if(stable>version.stable)
                    return BIGGER;
                else
                    return SMALLER;
            }else {
                if(beta == version.beta)
                    return EQUAL;
                else if (beta > version.beta)
                    return BIGGER;
                else
                    return SMALLER;
            }
        }
        public int isCompatible(Version version){
            return stable==version.stable ? COMPATIBLE : NOT_COMPATIBLE;
        }
    }

}
