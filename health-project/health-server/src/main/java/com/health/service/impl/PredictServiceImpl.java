package com.health.service.impl;

import com.health.dto.UserPredictDMDTO;
import com.health.dto.UserPredictDTO;
import com.health.entities.ChdRecord;
import com.health.entities.DmRecord;
import com.health.mapper.ChdRecordMapper;
import com.health.mapper.DmRecordMapper;
import com.health.service.PredictService;
import com.health.vo.PredictDMVO;
import com.health.vo.PredictVO;
import org.dmg.pmml.FieldName;
import org.dmg.pmml.PMML;
import org.jpmml.evaluator.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
//建议 分类 存库  建议库（数据库）
/**
 * @BelongsProject: sky_test
 * @BelongsPackage: com.health.service.impl
 * @Author: X_X
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class PredictServiceImpl implements PredictService {
    @Autowired
    ChdRecordMapper chdRecordMapper;
    @Autowired
    DmRecordMapper dmRecordMapper;

    @Override
    public PredictVO predict(UserPredictDTO predictDTO) {

        Map<String,Double> inputvector=new HashMap<String ,Double>();
        //加载模型
        Evaluator evaluator = loadPmml();

        //将结果插入数据库
        ChdRecord chdRecord=new ChdRecord();

        List<InputField> inputFields = evaluator.getInputFields();

        inputvector.put("Polyphagia_No", predictDTO.getPolyphagiaNo());
        switch (predictDTO.getPolyphagiaNo().intValue()){
            case 0:  chdRecord.setPolyphagia(0.0);
                    break;
            case 1:  chdRecord.setPolyphagia(1.0);
                    break;
            default: chdRecord.setPolyphagia(-1.0);
                    break;
        }

        inputvector.put("Gender_Female",predictDTO.getGenderFemale());
        switch (predictDTO.getUserSex()){
            case "0":  chdRecord.setUsersex("0");
                break;
            case "1":  chdRecord.setUsersex("1");
                break;
            default: chdRecord.setUsersex("-1");
                break;
        }

        inputvector.put("Polydipsia_Yes",predictDTO.getPolydipsiaYes());
        switch (predictDTO.getPolydipsiaYes().intValue()){
            case 0:  chdRecord.setPolydipsia(0.0);
                break;
            case 1:  chdRecord.setPolydipsia(1.0);
                break;
            default: chdRecord.setPolydipsia(-1.0);
                break;
        }


        inputvector.put("muscle stiffness_Yes",predictDTO.getMuscleStiffnessYes());
        switch (predictDTO.getMuscleStiffnessYes().intValue()){
            case 0:  chdRecord.setMuscleStiff(0.0);
                break;
            case 1:  chdRecord.setMuscleStiff(1.0);
                break;
            default: chdRecord.setMuscleStiff(-1.0);
                break;
        }

        inputvector.put("visual blurring_Yes",predictDTO.getVisualBlurringYes());
        switch (predictDTO.getVisualBlurringYes().intValue()){
            case 0:  chdRecord.setVisualBlurring(0.0);
                break;
            case 1:  chdRecord.setVisualBlurring(1.0);
                break;
            default: chdRecord.setVisualBlurring(-1.0);
                break;
        }

        inputvector.put("delayed healing_No",predictDTO.getDelayedHealingNo());
        switch (predictDTO.getDelayedHealingNo().intValue()){
            case 0:  chdRecord.setDelayedHealing(0.0);
                break;
            case 1:  chdRecord.setDelayedHealing(1.0);
                break;
            default: chdRecord.setDelayedHealing(-1.0);
                break;
        }

        inputvector.put("sudden weight loss_No",predictDTO.getSuddenWeightLossNo());
        switch (predictDTO.getSuddenWeightLossNo().intValue()){
            case 0:  chdRecord.setSunddenWeightLess(0.0);
                break;
            case 1:  chdRecord.setSunddenWeightLess(1.0);
                break;
            default: chdRecord.setSunddenWeightLess(-1.0);
                break;
        }

        inputvector.put("Irritability_No",predictDTO.getIrritabilityNo());
        switch (predictDTO.getIrritabilityNo().intValue()){
            case 0:  chdRecord.setIrritability(0.0);
                break;
            case 1:  chdRecord.setIrritability(1.0);
                break;
            default: chdRecord.setIrritability(-1.0);
                break;
        }

        inputvector.put("Polyuria_Yes",predictDTO.getPolyuriaYes());
        switch (predictDTO.getPolyuriaYes().intValue()){
            case 0:  chdRecord.setPolyuria(0.0);
                break;
            case 1:  chdRecord.setPolyuria(1.0);
                break;
            default: chdRecord.setPolyuria(-1.0);
                break;
        }

        inputvector.put("partial paresis_No",predictDTO.getPartialParesisNo());
        switch (predictDTO.getPartialParesisNo().intValue()){
            case 0:  chdRecord.setPartialParesis(0.0);
                break;
            case 1:  chdRecord.setPartialParesis(1.0);
                break;
            default: chdRecord.setPartialParesis(-1.0);
                break;
        }

        inputvector.put("Polydipsia_No",predictDTO.getPolydipsiaNo());

        inputvector.put("sudden weight loss_Yes",predictDTO.getSuddenWeightLossYes());

        inputvector.put("muscle stiffness_No",predictDTO.getMuscleStiffnessNo());

        inputvector.put("Alopecia_Yes",predictDTO.getAlopeciaYes());
        switch (predictDTO.getAlopeciaYes().intValue()){
            case 0:  chdRecord.setAlopecia(0.0);
                break;
            case 1:  chdRecord.setAlopecia(1.0);
                break;
            default: chdRecord.setAlopecia(-1.0);
                break;
        }

        inputvector.put("weakness_No",predictDTO.getWeaknessNo());
        switch (predictDTO.getWeaknessNo().intValue()){
            case 0:  chdRecord.setWeakness(0.0);
                break;
            case 1:  chdRecord.setWeakness(1.0);
                break;
            default: chdRecord.setWeakness(-1.0);
                break;
        }

        inputvector.put("visual blurring_No",predictDTO.getVisualBlurringNo());

        inputvector.put("Obesity_Yes",predictDTO.getObesityYes());
        switch (predictDTO.getObesityYes().intValue()){
            case 0:  chdRecord.setObesity(0);
                break;
            case 1:  chdRecord.setObesity(1);
                break;
            default: chdRecord.setObesity(-1);
                break;
        }

        inputvector.put("Polyuria_No",predictDTO.getPolyuriaNo());

        inputvector.put("Age",predictDTO.getUserAge());
        chdRecord.setUserage(predictDTO.getUserAge().intValue());

        inputvector.put("Alopecia_No",predictDTO.getAlopeciaNo());


        inputvector.put("weakness_Yes",predictDTO.getWeaknessYes());

        inputvector.put("delayed healing_Yes",predictDTO.getDelayedHealingYes());

        inputvector.put("Genital thrush_No",predictDTO.getGenitalThrushNo());
        switch (predictDTO.getGenitalThrushNo().intValue()){
            case 0:  chdRecord.setGenitalThrush(0.0);
                break;
            case 1:  chdRecord.setGenitalThrush(1.0);
                break;
            default: chdRecord.setGenitalThrush(-1.0);
                break;
        }

        inputvector.put("Itching_Yes",predictDTO.getItchingYes());
        switch (predictDTO.getItchingYes().intValue()){
            case 0:  chdRecord.setItching(0.0);
                break;
            case 1:  chdRecord.setItching(1.0);
                break;
            default: chdRecord.setItching(-1.0);
                break;
        }

        inputvector.put("Genital thrush_Yes",predictDTO.getGenitalThrushYes());

        inputvector.put("Itching_No",predictDTO.getItchingNo());

        inputvector.put("Obesity_No",predictDTO.getObesityNo());

        inputvector.put("Gender_Male",predictDTO.getGenderMale());

        inputvector.put("Polyphagia_Yes",predictDTO.getPolyphagiaYes());

        inputvector.put("Irritability_Yes",predictDTO.getIrritabilityYes());

        inputvector.put("partial paresis_Yes",predictDTO.getPartialParesisYes());

        Map<FieldName, FieldValue> arguments = new LinkedHashMap<FieldName, FieldValue>();
        for (InputField inputField : inputFields) {

            FieldName inputFieldName = inputField.getName();
            Object rawValue = inputvector.get(inputFieldName.getValue());
            FieldValue inputFieldValue = inputField.prepare(rawValue);
            arguments.put(inputFieldName, inputFieldValue);
        }



        chdRecord.setUsername(predictDTO.getUserName());
        chdRecord.setUserId(predictDTO.getUserId());

        Map<FieldName, ?> results = evaluator.evaluate(arguments);
        List<OutputField> outputFields = evaluator.getOutputFields();
        PredictVO predictVO = new PredictVO();
        int i=0;
        for (OutputField outputField : outputFields) {
            FieldName outputFieldName = outputField.getName();
            Object outputFieldValue = results.get(outputFieldName);
            if (i==0) {
                predictVO.setNegative((Double) outputFieldValue);
                chdRecord.setNegative((Double) outputFieldValue);
            }
            else{
              predictVO.setPositive((Double) outputFieldValue);
              chdRecord.setPositive((Double) outputFieldValue);
            }
            i=1;
        }

        //获取分数
        Double score = riskCalculator(predictDTO);
        chdRecord.setScore(score.intValue());
        chdRecord.setCreateTime(new Date());
        chdRecordMapper.insert(chdRecord);

       predictVO.setScore(score.intValue());
        return predictVO;
    }

    @Override
    public PredictDMVO predictDM(UserPredictDMDTO predictDMDTO) {
        Map<String,Double> inputvector=new HashMap<String ,Double>();
        //加载模型
        Evaluator evaluator = loadPmmlDM();

        List<InputField> inputFields = evaluator.getInputFields();

        inputvector.put("HighBP",predictDMDTO.getHighBP());
        inputvector.put("HighChol",predictDMDTO.getHighChol());
        inputvector.put("CholCheck",predictDMDTO.getCholCheck());
        inputvector.put("BMI",predictDMDTO.getBMI());
        inputvector.put("Smoker",predictDMDTO.getSmoker());
        inputvector.put("Stroke",predictDMDTO.getStroke());
        inputvector.put("HeartDiseaseorAttack",predictDMDTO.getHeartDiseaseorAttack());
        inputvector.put("PhysActivity",predictDMDTO.getPhysActivity());
        inputvector.put("Fruits",predictDMDTO.getFruits());
        inputvector.put("Veggies",predictDMDTO.getVeggies());
        inputvector.put("HvyAlcoholConsump",predictDMDTO.getHvyAlcoholConsump());
        inputvector.put("AnyHealthcare",predictDMDTO.getAnyHealthcare());
        inputvector.put("NoDocbcCost",predictDMDTO.getNoDocbcCost());
        inputvector.put("GenHlth",predictDMDTO.getGenHlth());
        inputvector.put("MentHlth",predictDMDTO.getMentHlth());
        inputvector.put("PhysHlth",predictDMDTO.getPhysHlth());
        inputvector.put("DiffWalk",predictDMDTO.getDiffWalk());
        inputvector.put("Sex", Double.valueOf(predictDMDTO.getUserSex()));
        inputvector.put("Age", predictDMDTO.getUserAge());
        inputvector.put("Education", predictDMDTO.getEducation());
        inputvector.put("Income", predictDMDTO.getIncome());



        Map<FieldName, FieldValue> arguments = new LinkedHashMap<FieldName, FieldValue>();
        for (InputField inputField : inputFields) {

            FieldName inputFieldName = inputField.getName();
            Object rawValue = inputvector.get(inputFieldName.getValue());
            FieldValue inputFieldValue = inputField.prepare(rawValue);
            arguments.put(inputFieldName, inputFieldValue);
        }

        DmRecord dmRecord=new DmRecord();
        dmRecord.setUsername(predictDMDTO.getUserName());
        dmRecord.setUserId(predictDMDTO.getUserId());

        Map<FieldName, ?> results = evaluator.evaluate(arguments);
        List<OutputField> outputFields = evaluator.getOutputFields();
        PredictDMVO predictDMVO = new PredictDMVO();
        int i=0;
        for (OutputField outputField : outputFields) {
            FieldName outputFieldName = outputField.getName();
            Object outputFieldValue = results.get(outputFieldName);
            if (i==0){
                predictDMVO.setProbability0((Double) outputFieldValue);
                dmRecord.setProbability0((Double) outputFieldValue);
            }
            else if (i==1) {
                predictDMVO.setProbability1((Double) outputFieldValue);
                dmRecord.setProbability1((Double) outputFieldValue);
            } else{
                predictDMVO.setProbability2((Double) outputFieldValue);
                dmRecord.setProbability2((Double) outputFieldValue);
            }
            i++;
        }
        return predictDMVO;
    }

    public  void get(){
         Evaluator evaluator = loadPmml();
         List<InputField> inputFields = evaluator.getInputFields();
         for (InputField inputField : inputFields) {
             System.out.println(inputField.getFieldName());
         }
     }

    public void getDM(){
        Evaluator evaluator = loadPmmlDM();
        List<InputField> inputFields = evaluator.getInputFields();
        for (InputField inputField : inputFields) {
            System.out.println(inputField.getFieldName());
        }
    }

    private Evaluator loadPmmlDM() {
        PMML pmml = new PMML();
        InputStream inputStream = null;
        // 构建相对路径，这里假设相对当前类所在的包路径往上找，找到resources目录下的template目录中的文件
        inputStream = PredictServiceImpl.class.getClassLoader().getResourceAsStream("template/diabetes_model.pmml");

        if(inputStream == null){
            return null;
        }
        InputStream is = inputStream;
        try {
            pmml = org.jpmml.model.PMMLUtil.unmarshal(is);}
        catch(org.xml.sax.SAXException e1) {
            e1.printStackTrace();
        }
        catch(javax.xml.bind.JAXBException e2) {
            e2.printStackTrace();
        }
        finally {
            //关闭输入流
            try {
                is.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ModelEvaluatorFactory modelEvaluatorFactory = ModelEvaluatorFactory.newInstance();
        Evaluator evaluator = modelEvaluatorFactory.newModelEvaluator(pmml);
        pmml=null;
        return evaluator;
    }

    private Evaluator loadPmml()//加载pmml文件
    {
        PMML pmml = new PMML();
        InputStream inputStream = null;
        // 构建相对路径，这里假设相对当前类所在的包路径往上找，找到resources目录下的template目录中的文件
        inputStream = PredictServiceImpl.class.getClassLoader().getResourceAsStream("template/diabetes_rf_model.pmml");

        if(inputStream == null){
            return null;
        }
        InputStream is = inputStream;
        try {
            pmml = org.jpmml.model.PMMLUtil.unmarshal(is);}
        catch(org.xml.sax.SAXException e1) {
            e1.printStackTrace();
        }
        catch(javax.xml.bind.JAXBException e2) {
            e2.printStackTrace();
        }
        finally {
            //关闭输入流
            try {
                is.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ModelEvaluatorFactory modelEvaluatorFactory = ModelEvaluatorFactory.newInstance();
        Evaluator evaluator = modelEvaluatorFactory.newModelEvaluator(pmml);
        pmml=null;
        return evaluator;
    }



    //冠心病参数加权
    public static Double riskCalculator(UserPredictDTO predictDTO){
        // 糖尿病症状列表（按参数顺序）:
        //多尿、多饮、体重下降、生殖器念珠菌病、视力模糊

       // 代谢症状包括：皮肤瘙痒、易怒、愈合延迟、四肢麻木、肌肉萎缩、脱发
//  | 年龄 | 30% | 实际年龄/10030 | 年龄是最重要的非修饰因素 |
//| 性别（男性） | 15% | 1→15分，0→7.5分，-1→0分 | 男性风险是女性的2-3倍 |
//| 肥胖（BMI≥28） | 20% | 1→20分，0→10分，-1→0分 | 肥胖直接导致代谢综合征 |
//| 糖尿病症状总分 | 25% | 每个阳性症状+3分，最高25分 | 糖尿病是CHD等危症 |
//| 代谢异常症状总分** | 10% | 每个阳性症状+2分，最高10分 | 反映胰岛素抵抗程度 |
        double score=0;

        // 年龄得分（线性计算）
        score += (predictDTO.getUserAge() / 100.0) * 30;

        // 性别得分
        score += mapGenderScore(Integer.parseInt(predictDTO.getUserSex()));


        score += mapObesityScore(predictDTO.getObesityYes());

        // 糖尿病症状得分
        int diabetesSymptomsScore = 0;
        if(predictDTO.getPolyuriaYes()==1){
            diabetesSymptomsScore+=3;
        }
        if(predictDTO.getPolydipsiaYes()==1){
            diabetesSymptomsScore+=3;
        }
        if(predictDTO.getSuddenWeightLossYes()==1){
            diabetesSymptomsScore+=3;
        }
        if(predictDTO.getGenitalThrushYes()==1){
            diabetesSymptomsScore+=3;
        }
        if(predictDTO.getVisualBlurringYes()==1){
            diabetesSymptomsScore+=3;
        }
       score+= Math.min(diabetesSymptomsScore, 25);

        // 代谢症状得分
        int metabolicSymptomsScore = 0;
        if(predictDTO.getItchingYes()==1){
         metabolicSymptomsScore+=2;
        }

        if(predictDTO.getIrritabilityYes()==1){
            metabolicSymptomsScore+=2;
        }

        if(predictDTO.getDelayedHealingYes()==1){
            metabolicSymptomsScore+=2;
        }

        if(predictDTO.getPartialParesisYes()==1){
            metabolicSymptomsScore+=2;
        }
        if (predictDTO.getMuscleStiffnessYes()==1){
            metabolicSymptomsScore+=2;
        }
        if(predictDTO.getAlopeciaYes()==1){
            metabolicSymptomsScore+=2;
        }
        score+= Math.min(metabolicSymptomsScore, 10);
        return score;
    }

    private static double mapGenderScore(int genderParam) {
        return switch (genderParam) {
            case 1 -> 15;   // 确认男性
            case 0 -> 7.5;  // 性别未知时取中间值
            default -> 0;    // 确认女性
        };
    }

    private static double mapObesityScore(Double obesityParam) {
        return switch (obesityParam.intValue()) {
            case 1 -> 20;   // 确认肥胖
            case 0 -> 10;  // 肥胖未知时取中间值
            default -> 0;    // 确认非肥胖
        };
    }
}

