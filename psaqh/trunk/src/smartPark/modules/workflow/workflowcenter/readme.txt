此模块可以放在其他模块里面，引入对一个的jar即可

对应的bpmn文件在src/main/resources/diagrams中
页面在pages/myflow和pages/workflow/run下

对应菜单：
	<menu id="990000" text="业务流程">
		<menu id="990100" text="流程管理" href="page/workflow.flow/flow.html"></menu>
		<menu id="990200" text="待办事项" href="page/workflow.task/task.html"></menu>
	</menu>
	
	物业报修	
用户申请	page/myflow.repair/userCreateAndSubmit.html
物业受理	page/myflow.repair/realestateAccept.html
物业派工	page/myflow.repair/realestateAssign.html
维修工接单	page/myflow.repair/maintainerReceive.html
维修工修理	page/myflow.repair/maintainerProcess.html
用户评价	page/myflow.repair/userAppraise.html
维修单详情	page/myflow.repair/repairOrder.html

