class TestResult:
    def __init__(self):
        self.runCount = 0
    def testStarted(self):
        self.runCount = self.runCount + 1
    def summary(self):
        return "%d run, 0 failed" % self.runCount

class TestCase:
    def __init__(self, name):
        self.name = name
    def setUp(self):
        pass
    def tearDown(self):
        pass
    def run(self):
        result = TestResult()
        result.testStarted()
        self.setUp()
        method = getattr(self, self.name)
        method()
        self.tearDown()
        return result

class WasRun(TestCase):
    def __init__(self, name):
        TestCase.__init__(self, name)
    def setUp(self):
        self.log = "setUp "
    def testMethod(self):
        self.log = self.log + "testMethod "
    def tearDown(self):
        self.log = self.log + "tearDown "
    def testBrokenMethod(self):
        raise Exception
        
class TestCaseTest(TestCase):
    def setUp(self):
        self.test = WasRun("testMethod")
    def testTemplateMethod(self):
        self.test.run()
        assert(self.test.log == "setUp testMethod tearDown ")
    def testResult(self):
        print(1)
        test = WasRun("testMethod")
        result = test.run()
        assert("1 run, 0 failed" == result.summary())
    def testFailedResult(self):
        test = WasRun("testBrokenMethod")
        result = test.run()
        assert("1 run, 1 failed" == result.summary())
        
TestCaseTest("testTemplateMethod").run()