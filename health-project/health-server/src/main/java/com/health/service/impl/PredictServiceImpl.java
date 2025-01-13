package com.health.service.impl;

import com.health.dto.UserPredictDTO;
import com.health.service.PredictService;
import com.health.vo.PredictVO;
import org.dmg.pmml.FieldName;
import org.dmg.pmml.PMML;
import org.jpmml.evaluator.*;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
    @Override
    public PredictVO predict(UserPredictDTO predictDTO) {
        String real=null;//初始值为-1，不代表任何的状态
        Map<String,Double> inputvector=new HashMap<String ,Double>();
        //加载模型
        Evaluator evaluator = loadPmml();

        List<InputField> inputFields = evaluator.getInputFields();

        inputvector.put("Polyphagia_No", predictDTO.getPolyphagiaNo());

        inputvector.put("Gender_Female",predictDTO.getGenderFemale());

        inputvector.put("Polydipsia_Yes",predictDTO.getPolydipsiaYes());


        inputvector.put("muscle stiffness_Yes",predictDTO.getMuscleStiffnessYes());

        inputvector.put("visual blurring_Yes",predictDTO.getVisualBlurringYes());

        inputvector.put("delayed healing_No",predictDTO.getDelayedHealingNo());

        inputvector.put("sudden weight loss_No",predictDTO.getSuddenWeightLossNo());

        inputvector.put("Irritability_No",predictDTO.getIrritabilityNo());

        inputvector.put("Polyuria_Yes",predictDTO.getPolyuriaYes());

        inputvector.put("partial paresis_No",predictDTO.getPartialParesisNo());

        inputvector.put("Polydipsia_No",predictDTO.getPolydipsiaNo());

        inputvector.put("sudden weight loss_Yes",predictDTO.getSuddenWeightLossYes());

        inputvector.put("muscle stiffness_No",predictDTO.getMuscleStiffnessNo());

        inputvector.put("Alopecia_Yes",predictDTO.getAlopeciaYes());

        inputvector.put("weakness_No",predictDTO.getWeaknessNo());

        inputvector.put("visual blurring_No",predictDTO.getVisualBlurringNo());

        inputvector.put("Obesity_Yes",predictDTO.getObesityYes());

        inputvector.put("Polyuria_No",predictDTO.getPolyuriaNo());

        inputvector.put("Age",predictDTO.getUserAge());

        inputvector.put("Alopecia_No",predictDTO.getAlopeciaNo());

        inputvector.put("weakness_Yes",predictDTO.getWeaknessYes());

        inputvector.put("delayed healing_Yes",predictDTO.getDelayedHealingYes());

        inputvector.put("Genital thrush_No",predictDTO.getGenitalThrushNo());

        inputvector.put("Itching_Yes",predictDTO.getItchingYes());

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


        Map<FieldName, ?> results = evaluator.evaluate(arguments);
        List<OutputField> outputFields = evaluator.getOutputFields();
        PredictVO predictVO = new PredictVO();
        int i=0;
        for (OutputField outputField : outputFields) {
            FieldName outputFieldName = outputField.getName();
            Object outputFieldValue = results.get(outputFieldName);
            if (i==0)
             predictVO.setNegative((Double) outputFieldValue);
            else
              predictVO.setPositive((Double) outputFieldValue);
            i=1;
        }
        return predictVO;
    }

     public  void get(){
         Evaluator evaluator = loadPmml();
         List<InputField> inputFields = evaluator.getInputFields();
         for (InputField inputField : inputFields) {
             System.out.println(inputField.getFieldName());
         }
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


}
